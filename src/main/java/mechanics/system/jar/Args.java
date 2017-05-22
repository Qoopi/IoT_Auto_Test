package mechanics.system.jar;

import com.beust.jcommander.Parameter;
import mechanics.system.readers.Variables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Storm on 16.05.2017.
 */
public class Args {
    @Parameter
    private List<String> parameters = new ArrayList<>();

    @Parameter(names = { "-stage", "-s" }, description = "Environment to test: dev/stage/other")
    private String stage = "wstaging";

    @Parameter(names = { "-file", "-f"}, description = "Test suite .xml file in xml/ folder")
    public String file = "testng.xml";

    public void setStage(){
        Variables variables = new Variables();
        variables.findAndAssembleStage(stage);
    }

    public void print() {
        System.out.println("Stage: "+stage);
        System.out.println("File: "+file);
    }
}
