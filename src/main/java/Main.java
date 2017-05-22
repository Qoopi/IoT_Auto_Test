import com.beust.jcommander.JCommander;
import mechanics.system.jar.Args;
import org.testng.TestNG;
import org.testng.collections.Lists;
import mechanics.system.jar.Unpack;
import ru.yandex.qatools.allure.report.AllureReportBuilder;
import ru.yandex.qatools.allure.report.AllureReportBuilderException;

import java.io.File;
import java.util.List;

/**
 * Created by Alex Storm on 12.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Args argv = new Args();
        if (args.length == 0) {
            String[] defArgs = {"-stage", "wstaging"};
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

        long time = System.currentTimeMillis();

        System.setProperty("allure.results.directory", "reports/allure_"+time);

        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("xml/testng.xml");//path to main .xml
        testng.setUseDefaultListeners(false);
        testng.setTestSuites(suites);
        testng.setVerbose(10);
        testng.run();

        File output = new File("reports/allure_"+time+"/allure-report/");
        File results = new File("reports/allure_"+time);
        System.out.println(output.getAbsolutePath());
        try {
            AllureReportBuilder allureReportBuilder = new AllureReportBuilder(output);
            allureReportBuilder.unpackFace();
            allureReportBuilder.processResults(results);
        } catch (AllureReportBuilderException e) {
            e.printStackTrace();
        }


        //if any test fails - exit code is 1
        if (testng.hasFailure() || testng.hasFailureWithinSuccessPercentage() || testng.hasSkip()) {
            System.exit(1);
        }
    }
}
