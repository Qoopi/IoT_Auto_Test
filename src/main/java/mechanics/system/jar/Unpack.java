package mechanics.system.jar;

import org.apache.commons.lang3.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Alex Storm on 12.05.2017.
 */
public class Unpack {

    public void unpackOnStart(){
        if (SystemUtils.IS_OS_WINDOWS) {
            unpackFile("chromedriver.exe", "/selenium/windows/chromedriver.exe");
            unpackFile("geckodriver32.exe", "/selenium/windows/geckodriver32.exe");
            unpackFile("IEDriverServer32.exe", "/selenium/windows/IEDriverServer32.exe");
            unpackFile("IEDriverServer64.exe", "/selenium/windows/IEDriverServer64.exe");
            unpackFile("MicrosoftWebDriver.exe", "/selenium/windows/MicrosoftWebDriver.exe");
        }
        if (SystemUtils.IS_OS_LINUX) {
            unpackFile("chromedriver", "/selenium/linux/chromedriver", true);
            unpackFile("geckodriver", "/selenium/linux/geckodriver", true);
        }
        unpackFile("api.xml", "/xml/api.xml");
        unpackFile("ui.xml", "/xml/ui.xml");
        unpackFile("load.xml", "/xml/load.xml");
        unpackFile("testng.xml", "/xml/testng.xml");
    }

    private void unpackFile(String newFile, String resourceFile){
        File file = new File(new File(newFile).getAbsolutePath());
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
