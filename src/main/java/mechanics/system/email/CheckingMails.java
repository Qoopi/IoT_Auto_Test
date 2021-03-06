package mechanics.system.email;

import mechanics.system.readers.Credentials;
import org.junit.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import javax.mail.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Kutafin Oleg on 24.04.2017.
 */
public class CheckingMails {
    public static boolean checkEmail(String host, String storeType, String userName, String password, String subject) {
        boolean found = false;
        try {

            // create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3s.host", host);
            properties.put("mail.pop3s.port", "995");
            properties.put("mail.pop3s.starttls.enable", "true");

            // Setup authentication, get session
            Session emailSession = Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(userName, password);
                }
            });
            //emailSession.setDebug(true);

            // create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect();

            // create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            found = false;

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent());
                System.out.println("Text: " + message.getContent().toString());
                System.out.println("Send at: " + message.getSentDate());

//                Assert.assertTrue(message.getSubject().contains(subject));
                if (message.getSubject().contains(subject)) {
                    System.out.println("Message with suitable Subject was found");
                    if (message.getSentDate().getTime() > (System.currentTimeMillis() - 60000)) {
                        System.out.println(message.getSentDate().getTime() + ">" + (System.currentTimeMillis() - 60000));
                        System.out.println("Message was sent lesser then 60 sec ago");
                        found = true;
                    }
                }
            }

            // close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }
    @Step("Checking if notification send on e-mail.")
    public void check(String subject) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Credentials credentials = new Credentials();
        HashMap<String, String> map = credentials.getCredentials();

        String mail = map.get("test_email");
        String pass = map.get("test_password");

        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String userName = mail;// change accordingly
        String password = pass;// change accordingly
        Assert.assertTrue(checkEmail(host, mailStoreType, userName, password, subject));

    }

    @Step("Checking if notification on e-mail.")
    public void checkLong(String subject){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Credentials credentials = new Credentials();
        HashMap<String, String> map = credentials.getCredentials();

        String mail = map.get("test_email");
        String pass = map.get("test_password");

        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String userName = mail;// change accordingly
        String password = pass;// change accordingly
        boolean found = false;
        found = checkEmail(host, mailStoreType, userName, password, subject);
        int counter = 0;
        while(!found && counter<6){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            found = checkEmail(host, mailStoreType, userName, password, subject);
            counter++;
        }
        Assert.assertTrue(found);
    }

}
