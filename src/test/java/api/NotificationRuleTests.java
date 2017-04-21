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

//    @Test
    public void alarmCountGPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.notificationRuleCreateAlarmCountGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
//        mqttManagerAPI.trigger
        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();

    }

//    @Test
    public void alarmCountVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.notificationRuleCreateAlarmCountVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
//        mqttManagerAPI.trigger
        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();

    }

//    @Test
    public void abortCountVPV(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.notificationRuleCreateAbortsCountVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
//        mqttManagerAPI.trigger
        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();

    }

    @Test
    public void disconnectedEquipmentGPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.equipmentConnectGPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.notificationRuleCreateDisconnectedGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.equipmentDisconnectGPV());
        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();

    }

    @Test
    public void disconnectedEquipmentVPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.equipmentConnectVPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.notificationRuleCreateDisconnectedVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.equipmentDisconnectVPV());
        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();

    }

    @Test
    public void connectedEquipmentGPV() {
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.equipmentDisconnectGPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.notificationRuleCreateConnectedGPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.equipmentConnectGPV());
        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();
    }


    @Test
    public void connectedEquipmentVPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.equipmentDisconnectVPV());
        requestManagerAPI.notificationRuleCreate(requestManagerAPI.notificationRuleCreateConnectedVPV());
        requestManagerAPI.checkNotificationRuleIsCreated();
        requestManagerAPI.checkNotificationRuleNotTriggered();
        requestManagerAPI.equipmentChangeState(requestManagerAPI.equipmentConnectVPV());
        requestManagerAPI.checkNotificationRuleTriggered();
        requestManagerAPI.notificationRuleDelete();

    }

}
