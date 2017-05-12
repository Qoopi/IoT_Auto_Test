import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import system.jar.Unpack;

import java.util.List;

/**
 * Created by Alex Storm on 12.05.2017.
 */
public class main {
    public static void main(String[] args) {
        Unpack unpack = new Unpack();
        unpack.unpackOnStart();
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("testng.xml");//path to xml..
        testng.setTestSuites(suites);
        testng.run();
    }
}
