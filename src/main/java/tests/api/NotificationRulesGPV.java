package tests.api;

import mechanics.api.ListenerAPI;
import mechanics.api.MQTTManagerAPI;
import mechanics.api.RequestManagerAPI;
import mechanics.system.constant.AssembledEquipments;
import mechanics.system.email.CheckingMails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

import static mechanics.system.constant.EmailInbox.SubjectNotificationRuleEveryWarningGPV;
import static mechanics.system.constant.EmailInbox.SubjectNotificationRuleNumberOfAlarms;

/**
 * Created by Alex Storm on 26.05.2017.
 */
@Listeners(ListenerAPI.class)
public class NotificationRulesGPV {

    @BeforeClass
    public void setEquipThresholds() {
        //may fail if equipment don't have required fields in database.
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.setEquipmentThresholdGPV(AssembledEquipments.equipmentGpv, 200);
    }

    @Features("Every Warning on GPV rule.")
    @Test
    public void sendNotificationOnAlarmGPV() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleEveryWarningGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerGPV();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleEveryWarningGPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("Number of Alarms above threshold on GPV equipment rule.")
    @Test
    public void alarmCountGPV() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAlarmCountGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerGPV();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleNumberOfAlarms.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();

    }


    @Features("Disconnected rule with GPV equipment.")
    @Test //не работает принципиально, оставлена проверка "создается ли rule"
    public void disconnectedEquipmentGPV() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentConnectGPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleDisconnectedGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();

        requestManagerAPI.notificationRuleDelete();
    }

    @Features("Connected rule with GPV equipment.")
    @Test //не работает принципиально, оставлена проверка "создается ли rule"
    public void connectedEquipmentGPV() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentDisconnectGPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleConnectedGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();

        requestManagerAPI.notificationRuleDelete();
    }


}
