package mechanics.system.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by user on 31.03.2017.
 */

public class Credentials {

    private Properties prop = new Properties();
    private InputStream input = null;
    private static HashMap<String, String> credentials = null;
    private static final String credentialFile = "credentials.properties";

    public HashMap<String, String> getCredentials(){
        if (credentials!=null && !credentials.isEmpty()){
            return credentials;
        }
        File f = new File(credentialFile);
        if(f.exists() && !f.isDirectory()) {
            System.out.println("File credentials.properties found, processing...");
            return readProperties();
        }
        else {
            System.out.println("File credentials.properties not found, reading credentials from environment");
            return readEnv();
        }
    }

    private HashMap<String, String> readProperties() {
        credentials = new HashMap<>();

        try {
            input = new FileInputStream(credentialFile);

            // load a properties file
            prop.load(input);

            // get the properties value and save them in Map
            credentials.put("test_email", prop.getProperty("test_email"));
            credentials.put("test_password", prop.getProperty("test_password"));
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

    private HashMap<String, String> readEnv() {
        credentials = new HashMap<>();
        credentials.put("test_email", System.getenv("test_email"));
        credentials.put("test_password", System.getenv("test_password"));
        return credentials;
    }
}
