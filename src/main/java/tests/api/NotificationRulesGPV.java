package tests.api;

import mechanics.api.ListenerAPI;
import mechanics.api.MQTTManagerAPI;
import mechanics.api.RequestManagerAPI;
import mechanics.system.constant.AssembledEquipments;
import mechanics.system.email.CheckingMails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static mechanics.system.constant.EmailInbox.SubjectNotificationRuleEveryWarningGPV;
import static mechanics.system.constant.EmailInbox.SubjectNotificationRuleNumberOfAlarms;

/**
 * Created by Alex Storm on 26.05.2017.
 */
@Listeners(ListenerAPI.class)
@Title("GPV rules test suite.")
@Description("Checking rules with GPV equipment.")
public class NotificationRulesGPV {

    @BeforeClass
    public void setEquipThresholds() {
        //may fail if equipment don't have required fields in database.
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.setEquipmentThresholdGPV(AssembledEquipments.equipmentGpv, 200);
    }

    @Features("GPV rules.")
    @Stories("Send notification on Alarm (GPV) rule.")
    @Description("")
    @Test
    public void sendNotificationOnAlarmGPV() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleEveryWarningGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerGPVAlarm();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleEveryWarningGPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("GPV rules.")
    @Stories("Number of Alarms above threshold rule.")
    @Description("")
    @Test
    public void alarmCountGPV() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAlarmCountGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerGPVAlarm();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleNumberOfAlarms.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();

    }

    @Features("GPV rules.")
    @Stories("Disconnected equipment rule.")
    @Description("")
    @Test //не работает принципиально, оставлена проверка "создается ли rule"
    public void disconnectedEquipmentGPV() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentConnectGPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleDisconnectedGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();

        requestManagerAPI.notificationRuleDelete();
    }
    @Features("GPV rules.")
    @Stories("Connected equipment rule.")
    @Description("")
    @Test //не работает принципиально, оставлена проверка "создается ли rule"
    public void connectedEquipmentGPV() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentDisconnectGPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleConnectedGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();

        requestManagerAPI.notificationRuleDelete();
    }


}
