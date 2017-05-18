import com.beust.jcommander.JCommander;
import mechanics.system.jar.Args;
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
        Args argv = new Args();
        if (args.length == 0) {
            String[] defArgs = {"-stage", "dev"};
            JCommander.newBuilder()
                    .addObject(argv)
                    .build()
                    .parse(defArgs);
            System.out.print("No arguments found, using default - ");
            argv.print();
        } else {
            JCommander.newBuilder()
                    .addObject(argv)
                    .build()
                    .parse(args);
            argv.print();
        }
        Unpack unpack = new Unpack();
        unpack.unpackOnStart();
        argv.setStage();
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("xml/testng.xml");//path to main .xml
        testng.setTestSuites(suites);
        testng.setVerbose(1);
        testng.run();
        //if any test fails - exit code is 1
        if (testng.hasFailure() || testng.hasFailureWithinSuccessPercentage() || testng.hasSkip()) {
            System.exit(2);
        }
    }
}
