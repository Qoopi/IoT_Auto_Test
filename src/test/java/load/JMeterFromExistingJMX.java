package load;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.testng.annotations.Test;

import java.io.FileInputStream;

/**
 * Created by user on 10.03.2017.
 */
public class JMeterFromExistingJMX {

    @Test
    public static void jmeterTest() throws Exception {
        // JMeter Engine
        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        // Initialize Properties, logging, locale, etc.
        JMeterUtils.loadJMeterProperties("src/main/resources/apache-jmeter-3.1/bin/jmeter.properties");
        JMeterUtils.setJMeterHome("src/main/resources/apache-jmeter-3.1");
//        JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
        JMeterUtils.initLocale();

        // Initialize JMeter SaveService
        SaveService.loadProperties();

        // Load existing .jmx Test Plan
        FileInputStream in = new FileInputStream("src/main/resources/records/RecordTest0903.jmx");
        HashTree testPlanTree = SaveService.loadTree(in);
        in.close();

        // Run JMeter Test
        jmeter.configure(testPlanTree);
        jmeter.run();
    }
}
