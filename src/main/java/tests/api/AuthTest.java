package tests.api;

import mechanics.api.RequestManagerAPI;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

/**
 * Created by Alex Storm on 23.05.2017.
 */
public class AuthTest {
    @Features("Re-authorisation")
    @Test
    public void checkAuthRefresh(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        //check, if creds now are ok
        requestManagerAPI.notificationListRead();
        //get new creds and use them
        requestManagerAPI.authenticationRefresh();
        //check, if new creds are ok
        requestManagerAPI.notificationListRead();
    }
}
