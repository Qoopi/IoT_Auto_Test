package tests.api;

import mechanics.api.ListenerAPI;
import mechanics.api.RequestManagerAPI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Alex Storm on 23.05.2017.
 */
@Listeners(ListenerAPI.class)
@Title("Re-authorisation test suite.")
public class AuthTest {
    @Features("Re-authorisation")
    @Stories("[OSF]-707 Logout should check authentication service for sessions validity")
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
