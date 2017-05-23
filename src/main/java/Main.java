import com.beust.jcommander.JCommander;
import mechanics.system.jar.Args;
import mechanics.system.jar.Unpack;
import org.testng.TestNG;
import org.testng.collections.Lists;
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
        JCommander.newBuilder()
                .addObject(argv)
                .build()
                .parse(args);
        argv.help();
        argv.print();

        Unpack unpack = new Unpack();
        unpack.unpackOnStart();
        argv.setStage();

        long time = System.currentTimeMillis();

        System.setProperty("allure.results.directory", "reports/allure_" + Args.stage +"_"+ time);

        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        if (new File("xml/"+Args.file).exists()){
            suites.add("xml/" + Args.file);
        }
        else{
            System.out.println("ERR: XML File 'xml/"+Args.file+"' not found");
            System.exit(1);
        }
        testng.setUseDefaultListeners(false);
        testng.setTestSuites(suites);
        testng.setVerbose(2);
        testng.run();

        File output = new File("reports/allure_" + Args.stage +"_"+ time + "/allure-report/");
        File results = new File("reports/allure_" + Args.stage+"_"+ time);
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
