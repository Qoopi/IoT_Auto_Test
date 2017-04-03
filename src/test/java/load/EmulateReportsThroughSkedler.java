package load;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 03.04.2017.
 */

@Listeners(LoadListener.class)
public class EmulateReportsThroughSkedler {

    @Test
    public void createReport(){
        RequestManager requestManager = new RequestManager();
        requestManager.skedlerReportCreate();
    }
}
