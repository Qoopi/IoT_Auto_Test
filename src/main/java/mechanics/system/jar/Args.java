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

    @Parameter(names = { "-stage", "-s" }, description = "Environment to test: dev/stage", echoInput = true)
    private String stage;

    @Parameter(names = {"-region", "-r"}, description = "Region of test environment", echoInput = true)
    private String groups;

    public void setStage(){
        Variables variables = new Variables();
        variables.findAndAssembleStage(stage);
    }

    public void print() {
        System.out.println("stage: "+stage);
    }
}
