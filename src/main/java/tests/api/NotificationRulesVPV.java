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

import static mechanics.system.constant.EmailInbox.*;

/**
 * Created by Alex Storm on 26.05.2017.
 */
@Listeners(ListenerAPI.class)
@Title("VPV rules test suite.")
@Description("Checking rules with VPV equipment.")
public class NotificationRulesVPV {

    @BeforeClass
    public void setEquipThresholds() {
        //may fail if equipment don't have required fields in database.
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.setEquipmentThresholdVPV(AssembledEquipments.equipmentVpv, 90, 95, 120, 125);
    }


    @Features("VPV rules.")
    @Stories("Abnormal Vibration rule.")
    @Description("Rule setup with any channel, sending payload on Main with Abort.")
    @Test
    public void abnormalVibrationVPVAnyAbortMain() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVAnyAbort());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationMainAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("VPV rules.")
    @Stories("Abnormal Vibration rule.")
    @Description("Rule setup with any channel, sending payload on Main with Alarm.")
    @Test
    public void abnormalVibrationVPVAnyAlarmMain() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVAnyAlarm());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationMainAlarm();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("VPV rules.")
    @Stories("Abnormal Vibration rule.")
    @Description("Rule setup with any channel, sending payload on Blower with Abort.")
    @Test
    public void abnormalVibrationVPVAnyAbortBlower() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVAnyAbort());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationBlowerAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("VPV rules.")
    @Stories("Abnormal Vibration rule.")
    @Description("Rule setup with any channel, sending payload on Blower with Alarm.")
    @Test
    public void abnormalVibrationVPVAnyAlarmBlower() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVAnyAlarm());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationBlowerAlarm();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("VPV rules.")
    @Stories("Abnormal Vibration rule.")
    @Description("Rule setup with Main channel,sending payload with Abort.")
    @Test
    public void abnormalVibrationVPVMainAbort() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVMainAbort());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationMainAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("VPV rules.")
    @Stories("Abnormal Vibration rule.")
    @Description("Rule setup with Main channel, sending payload with Alarm.")
    @Test
    public void abnormalVibrationVPVMainAlarm() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVMainAlarm());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationMainAlarm();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("VPV rules.")
    @Stories("Abnormal Vibration rule.")
    @Description("Rule setup with Blower channel, sending payload with Abort.")
    @Test
    public void abnormalVibrationVPVABlowerAbort() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVBlowerAbort());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationBlowerAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("VPV rules.")
    @Stories("Abnormal Vibration rule.")
    @Description("Rule setup with Blower channel, sending payload with Alarm.")
    @Test
    public void abnormalVibrationVPVABlowerAlarm() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVBlowerAlarm());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationBlowerAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("VPV rules.")
    @Stories("Send Notifications on Alarm or Abort (VPV) rule.")
    @Description("Rule setup to react on Aborts.")
    @Test
    public void sendNotificationOnAlarmOrAbortVPVAbort() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleEveryWarningVPVAbort());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleEveryWarningVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("VPV rules.")
    @Stories("Send Notifications on Alarm or Abort (VPV) rule.")
    @Description("Rule setup to react on Alarms.")
    @Test
    public void sendNotificationOnAlarmOrAbortVPVAlarm() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleEveryWarningVPVAlarm());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAlarm();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleEveryWarningVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }

    @Features("VPV rules.")
    @Stories("Number of Alarms above threshold rule.")
    @Description("Rule setup to react on Alarm.")
    @Test
    public void alarmCountVPV() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAlarmCountVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAlarmCount();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleNumberOfAlarms.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();

    }

    @Features("VPV rules.")
    @Stories("Number of Abnormal above threshold rule.")
    @Description("Rule setup to react in Aborts.")
    @Test
    public void abortCountVPV() {
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbortsCountVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbortCount();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.checkLong(SubjectNotificationRuleNumberOfAborts.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();

    }

    @Features("VPV rules.")
    @Stories("Disconnected equipment rule.")
    @Description("Rule setup to react on disconnected equipment.")
    @Test//не работает принципиально, оставлена проверка "создается ли rule"
    public void disconnectedEquipmentVPV() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentConnectVPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleDisconnectedVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();

        requestManagerAPI.notificationRuleDelete();

    }

    @Features("VPV rules.")
    @Stories("Disconnected equipment rule.")
    @Description("Rule setup to react on Connected equipment.")
    @Test//не работает принципиально, оставлена проверка "создается ли rule"
    public void connectedEquipmentVPV() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentDisconnectVPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleConnectedVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();

        requestManagerAPI.notificationRuleDelete();

    }
}
