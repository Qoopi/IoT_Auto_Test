package api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
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

    @Test
    public void abnormalVibrationVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.JSONRuleAbnormalVibrationVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVD11AbnormalVibration();
        requestManagerAPI.checkNotificationRuleTriggered();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationRuleDelete();
    }

    @Test
    public void everyWarningVPVAbnormalVibration(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.JSONRuleEveryWarningVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVD11AbnormalVibration();
        requestManagerAPI.checkNotificationRuleTriggered();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleEveryWarning.getMessage());
        requestManagerAPI.notificationRuleDelete();
    }

    @Test
    public void alarmCountVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.JSONRuleAlarmCountVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAlarmCount();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleNumberOfAlarms.getMessage());
        requestManagerAPI.notificationRuleDelete();

    }

    @Test
    public void abortCountVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.JSONRuleAbortsCountVPV());
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
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.JSONRuleAlarmCountGPV());
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
        requestManagerAPI.equipmentChangeState(requestManagerAPI.JSONEquipmentConnectVPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.JSONRuleDisconnectedVPV());
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
        requestManagerAPI.equipmentChangeState(requestManagerAPI.JSONEquipmentDisconnectVPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.JSONRuleConnectedVPV());
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
        requestManagerAPI.equipmentChangeState(requestManagerAPI.JSONEquipmentConnectGPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.JSONRuleDisconnectedGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();


        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();
    }

    //    @Test //не работает принципиально
    public void connectedEquipmentGPV() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.JSONEquipmentDisconnectGPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.JSONRuleConnectedGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();


        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();
    }


}
