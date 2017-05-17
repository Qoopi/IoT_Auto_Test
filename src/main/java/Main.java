import com.beust.jcommander.JCommander;
import mechanics.system.constant.AssembledUrls;
import mechanics.system.jar.Args;
import mechanics.system.readers.Variables;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import mechanics.system.jar.Unpack;

import java.util.List;

/**
 * Created by Alex Storm on 12.05.2017.
 */
public class Main {
    public static void main(String[] args) {
//        String[] ar = {"-stage", "dev"};
        Args argv = new Args();
        JCommander.newBuilder()
                .addObject(argv)
                .build()
                .parse(args);
        argv.print();
        argv.setStage();

        System.out.println(AssembledUrls.authenticationRefresh);
        System.out.println(AssembledUrls.chart);
        System.out.println(AssembledUrls.iotEndpoint);


        Unpack unpack = new Unpack();
        unpack.unpackOnStart();
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("xml/testng.xml");//path to xml..
        testng.setTestSuites(suites);
        testng.setVerbose(2);
        testng.run();
    }
}
