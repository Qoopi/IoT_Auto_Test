package universal;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by user on 31.03.2017.
 */

public class CredentialCenter {

    private Properties prop = new Properties();
    private InputStream input = null;
    private static HashMap<String, String> credentials = null;

    public HashMap<String, String> readProperties() {
        credentials = new HashMap<>();

        try {
            input = new FileInputStream("src/main/resources/credentials/credentials.properties");

            // load a properties file
            prop.load(input);

            // get the properties value and save them in Map
            credentials.put("email", prop.getProperty("email"));
            credentials.put("password", prop.getProperty("password"));
            credentials.put("email2", prop.getProperty("email2"));
            credentials.put("password2", prop.getProperty("password2"));
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return credentials;
    }
}
