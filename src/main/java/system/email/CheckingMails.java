package system.email;

import system.readers.CredentialCenter;

import javax.mail.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by Kutafin Oleg on 24.04.2017.
 */
public class CheckingMails {
    private static String  mail = null;
    private static String pass = null;

    public static void checkEmail(String host, String storeType, String userName, String password, String subject) {
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

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
                System.out.println("Send at: "+message.getSentDate());

//                Assert.assertTrue(message.getSubject().contains(subject));
               if (message.getSubject().contains(subject)){
                    System.out.println("hello, you suck dicks!");
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
    }

    public void check(String subject) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CredentialCenter credentialCenter = new CredentialCenter();
        HashMap<String, String> map = credentialCenter.readProperties();

        mail = map.get("email");
        pass = map.get("password");

        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String userName = mail;// change accordingly
        String password = pass;// change accordingly
        //String subject = SubjectNotificationRuleAbnormalVibrations.getMessage();
        checkEmail(host, mailStoreType, userName, password, subject);

    }

}
