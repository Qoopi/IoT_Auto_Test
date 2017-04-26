package api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import system.email.CheckingMails;

import static system.constant.EmailINBOX.*;

/**
 * Created by user on 20.04.2017.
 */
@Listeners(ListenerAPI.class)
public class NotificationRuleTests {

    @AfterClass
    public void afterTest(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
       requestManagerAPI.notificationListDeleteAll();
    }
    @Features("Abnormal Vibration rule.")
    @Test
    public void abnormalVibrationVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVD11AbnormalVibration();
        requestManagerAPI.checkNotificationRuleTriggered();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Every Warning on VPV rule.")
    @Test
    public void everyWarningVPVAbnormalVibration(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleEveryWarningVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVD11AbnormalVibration();
        requestManagerAPI.checkNotificationRuleTriggered();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleEveryWarning.getMessage());
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Number of Alarms above threshold on VPV equipment rule.")
    @Test
    public void alarmCountVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAlarmCountVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAlarmCount();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleNumberOfAlarms.getMessage());
        requestManagerAPI.notificationRuleDelete();

    }
    @Features("Number of Abnormal above threshold on VPV equipment rule.")
    @Test
    public void abortCountVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbortsCountVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbortCount();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleNumberOfAborts.getMessage());
        requestManagerAPI.notificationRuleDelete();

    }


    //    @Test //не работает по тому что нет возможности симулировать GPV
    public void alarmCountGPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAlarmCountGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
//        mqttManagerAPI.trigger
        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();

    }

    //    @Test//не работает принципиально
    public void disconnectedEquipmentVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentConnectVPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleDisconnectedVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVConnected();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVDisconected();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        requestManagerAPI.notificationRuleDelete();

    }

    //    @Test//не работает принципиально
    public void connectedEquipmentVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentDisconnectVPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleConnectedVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVDisconected();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVConnected();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        requestManagerAPI.notificationRuleDelete();

    }


    //    @Test //не работает принципиально
    public void disconnectedEquipmentGPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentConnectGPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleDisconnectedGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();


        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();
    }

    //    @Test //не работает принципиально
    public void connectedEquipmentGPV() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentDisconnectGPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleConnectedGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();


        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();
    }


}
