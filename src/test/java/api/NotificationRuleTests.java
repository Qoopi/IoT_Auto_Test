package api;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 20.04.2017.
 */
@Listeners(ListenerAPI.class)
public class NotificationRuleTests {


    @Test
    public void abnormalVibrationVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.notificationRuleCreateAbnormalVibrationVPVPumpD11());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVD11AbnormalVibration();
        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();
    }

}
