package load;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by alex00x on 30.03.2017.
 */

@Listeners(LoadListener.class)
public class EmulateCRUD {

    @Test
    public void createNotificationRule(){
        RequestManager requestManager = new RequestManager();
        requestManager.notificationRuleCreate();
    }
}
