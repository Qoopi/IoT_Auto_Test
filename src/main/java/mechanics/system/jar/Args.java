package mechanics.system.jar;

import com.beust.jcommander.Parameter;
import mechanics.system.readers.Variables;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Storm on 16.05.2017.
 */
public class Args {
    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = { "-stage", "-s" }, description = "Environment to test: dev/stage/other")
    private static String stage = "wstaging";

    @Parameter(names = { "-file", "-f"}, description = "Test suite .xml file in xml/ folder")
    public static String file = "testng.xml";

    @Parameter(names = {"-browser", "-b"}, description = "Browser name for selenium")
    public static String browser = "chrome";

    @Parameter(names = {"-grid", "-g"}, description = "Use selenium grid?")
    public static boolean grid = false;

    public void setStage(){
        Variables variables = new Variables();
        variables.findAndAssembleStage(stage);
    }

    public void print() {
        System.out.println("Stage: "+stage);
        System.out.println("Browser: "+browser);
        System.out.println("Selenium grid: "+grid);
        System.out.println("File: "+new File(file).getAbsoluteFile());
    }
}
