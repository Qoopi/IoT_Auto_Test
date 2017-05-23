package tests.api;

import mechanics.api.RequestManagerAPI;
import org.testng.annotations.Test;

/**
 * Created by Alex Storm on 23.05.2017.
 */
public class AuthTest {

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
