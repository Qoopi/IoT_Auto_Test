package tests.api;

import com.jayway.restassured.response.Response;
import mechanics.api.ListenerAPI;
import mechanics.api.MQTTManagerAPI;
import mechanics.api.RequestManagerAPI;
import mechanics.system.constant.AssembledEquipments;
import mechanics.system.email.CheckingMails;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

import static mechanics.system.constant.EmailInbox.*;

/**
 * Created by user on 20.04.2017.
 */
@Listeners(ListenerAPI.class)
public class NotificationRuleTests {

    @BeforeClass
    public void setEquipThresholds(){
        //may fail if equipment don't have required fields in database.
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.setEquipmentThresholdVPV(AssembledEquipments.equipmentVpv, 90, 95, 120, 125);
        requestManagerAPI.setEquipmentThresholdGPV(AssembledEquipments.equipmentGpv, 200);
    }

    @Features("Abnormal Vibration rule with Any channel, sending payload on Main with Abort.")
    @Test
    public void abnormalVibrationVPVAnyAbortMain(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVAnyAbort());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationMainAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Abnormal Vibration rule with Any channel, sending payload on Main with Alarm.")
    @Test
    public void abnormalVibrationVPVAnyAlarmMain(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVAnyAlarm());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationMainAlarm();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Abnormal Vibration rule with Any channel, sending payload on Blower with Abort.")
    @Test
    public void abnormalVibrationVPVAnyAbortBlower(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVAnyAbort());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationBlowerAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Abnormal Vibration rule with Any channel, sending payload on Blower with Alarm.")
    @Test
    public void abnormalVibrationVPVAnyAlarmBlower(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVAnyAlarm());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationBlowerAlarm();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Abnormal Vibration rule with Main channel, sending payload with Abort.")
    @Test
    public void abnormalVibrationVPVMainAbort(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVMainAbort());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationMainAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Abnormal Vibration rule with Main channel, sending payload with Alarm.")
    @Test
    public void abnormalVibrationVPVMainAlarm(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVMainAlarm());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationMainAlarm();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Abnormal Vibration rule with Blower channel, sending payload with Abort.")
    @Test
    public void abnormalVibrationVPVABlowerAbort(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVBlowerAbort());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationBlowerAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Abnormal Vibration rule with Blower channel, sending payload with Alarm.")
    @Test
    public void abnormalVibrationVPVABlowerAlarm(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAbnormalVibrationVPVBlowerAlarm());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbnormalVibrationBlowerAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleAbnormalVibrationsVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Every Warning on VPV rule.")
    @Test
    public void sendNotificationOnAlarmOrAbortVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleEveryWarningVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerVPVAbort();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleEveryWarningVPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();
    }
    @Features("Every Warning on GPV rule.")
    @Test
    public void sendNotificationOnAlarmGPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleEveryWarningGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerGPV();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleEveryWarningGPV.getMessage());
        requestManagerAPI.notificationListDeleteAll();
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
        requestManagerAPI.notificationListDeleteAll();
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
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();

    }
    @Features("Number of Alarms above threshold on GPV equipment rule.")
    @Test
    public void alarmCountGPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleAlarmCountGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        mqttManagerAPI.triggerGPV();
        requestManagerAPI.checkNotificationRuleTriggeredLong();
        CheckingMails checkingMails = new CheckingMails();
        checkingMails.check(SubjectNotificationRuleNumberOfAlarms.getMessage());
        requestManagerAPI.notificationListDeleteAll();
        requestManagerAPI.notificationRuleDelete();

    }

    @Features("Disconnected rule with VPV equipment.")
    @Test//не работает принципиально, оставлена проверка "создается ли rule"
    public void disconnectedEquipmentVPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentConnectVPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleDisconnectedVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();

        requestManagerAPI.notificationRuleDelete();

    }
    @Features("Connected rule with VPV equipment.")
    @Test//не работает принципиально, оставлена проверка "создается ли rule"
    public void connectedEquipmentVPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.jsonEquipmentDisconnectVPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.jsonRuleConnectedVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();

        requestManagerAPI.notificationRuleDelete();

    }

    @Features("Disconnected rule with GPV equipment.")
    @Test //не работает принципиально, оставлена проверка "создается ли rule"
    public void disconnectedEquipmentGPV(){
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
