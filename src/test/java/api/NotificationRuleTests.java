package api;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 20.04.2017.
 */
@Listeners(ListenerAPI.class)
public class NotificationRuleTests {

    @Test
    public void firstTest(){
        //создание рула
        //проверка рула
        //удаление рула
    }

    @Test
    public void test1(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        String shit = requestManagerAPI.notificationRuleCreateAbnormalVibrationRuleVPVPumpD11();
        System.out.println(shit);
        requestManagerAPI.notificationRuleCreate(shit);
        requestManagerAPI.checkNotificationRuleIsCreated();
    }
}
