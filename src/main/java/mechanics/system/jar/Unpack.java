package mechanics.system.jar;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * Created by Alex Storm on 12.05.2017.
 */
public class Unpack {

    public void unpackOnStart(){
        if (SystemUtils.IS_OS_WINDOWS) {
            unpackFile("selenium/chromedriver.exe", "/selenium/windows/chromedriver.exe");
            unpackFile("selenium/geckodriver32.exe", "/selenium/windows/geckodriver32.exe");
            unpackFile("selenium/IEDriverServer32.exe", "/selenium/windows/IEDriverServer32.exe");
            unpackFile("selenium/IEDriverServer64.exe", "/selenium/windows/IEDriverServer64.exe");
            unpackFile("selenium/MicrosoftWebDriver.exe", "/selenium/windows/MicrosoftWebDriver.exe");
        }
        if (SystemUtils.IS_OS_LINUX) {
            unpackFile("selenium/chromedriver", "/selenium/linux/chromedriver", true);
            unpackFile("selenium/geckodriver", "/selenium/linux/geckodriver", true);
        }
        unpackFile("xml/api.xml", "/xml/api.xml");
        unpackFile("xml/ui.xml", "/xml/ui.xml");
        unpackFile("xml/load.xml", "/xml/load.xml");
        unpackFile("xml/testng.xml", "/xml/testng.xml");
        unpackFile("xml/fortest.xml", "/xml/fortest.xml");
    }

    private void unpackFile(String newFile, String resourceFile){
        File file = new File(new File(newFile).getAbsolutePath());
        if (!file.getAbsoluteFile().getParentFile().exists()){
            file.getAbsoluteFile().getParentFile().mkdirs();
        }
        if (!file.exists()) {
            InputStream link = (getClass().getResourceAsStream(resourceFile));
            try {
                Files.copy(link, file.getAbsoluteFile().toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void unpackFile(String newFile, String resourceFile, boolean setExecutable){
        File file = new File(new File(newFile).getAbsolutePath());
        if (!file.getAbsoluteFile().getParentFile().exists()){
            file.getAbsoluteFile().getParentFile().mkdirs();
        }
        if (!file.exists()) {
            InputStream link = (getClass().getResourceAsStream(resourceFile));
            try {
                Files.copy(link, file.getAbsoluteFile().toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            file.setExecutable(true);
        }

    }
}
