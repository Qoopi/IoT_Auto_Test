package mechanics.api;

import mechanics.system.constant.AssembledEquipments;
import mechanics.system.mqtt.MQTTConnector;
import mechanics.system.mqtt.PayloadGPV;
import mechanics.system.mqtt.PayloadVPV;
import ru.yandex.qatools.allure.annotations.Step;


/**
 * Created by user on 21.04.2017.
 */
public class MQTTManagerAPI extends MQTTConnector {
    @Step("Sending payload with Abort to VPV equipment on Main channel")
    public void triggerVPVAbnormalVibrationMainAbort(){
        String topic = AssembledEquipments.equipmentVpvData;
        String payload = PayloadVPV.newBuilder().setAbnormalVibrationMain(666).setId(AssembledEquipments.equipmentVpv).initialize();
        mqttPublish(topic, payload);
    }
    @Step("Sending payload with Alarm to VPV equipment on Main channel")
    public void triggerVPVAbnormalVibrationMainAlarm(){
        String topic = AssembledEquipments.equipmentVpvData;
        String payload = PayloadVPV.newBuilder().setAbnormalVibrationMain(91).setId(AssembledEquipments.equipmentVpv).initialize();
        mqttPublish(topic, payload);
    }
    @Step("Sending payload with Abort to VPV equipment on Blower channel")
    public void triggerVPVAbnormalVibrationBlowerAbort(){
        String topic = AssembledEquipments.equipmentVpvData;
        String payload = PayloadVPV.newBuilder().setAbnormalVibrationBlower(666).setId(AssembledEquipments.equipmentVpv).initialize();
        mqttPublish(topic, payload);
    }
    @Step("Sending payload with Abort to VPV equipment on Blower channel")
    public void triggerVPVAbnormalVibrationBlowerAlarm(){
        String topic = AssembledEquipments.equipmentVpvData;
        String payload = PayloadVPV.newBuilder().setAbnormalVibrationBlower(96).setId(AssembledEquipments.equipmentVpv).initialize();
        mqttPublish(topic, payload);
    }


    @Step("Sending payload to VPV equipment with Abort")
    public void triggerVPVAbort(){
        String topic = AssembledEquipments.equipmentVpvData;
        String payload = PayloadVPV.newBuilder().setMaxDistanceMain(666).setId(AssembledEquipments.equipmentVpv).initialize();
        mqttPublish(topic, payload);
    }
    @Step("Sending payload to VPV equipment with Abort")
    public void triggerVPVAlarm(){
        String topic = AssembledEquipments.equipmentVpvData;
        String payload = PayloadVPV.newBuilder().setMaxDistanceMain(100).setId(AssembledEquipments.equipmentVpv).initialize();
        mqttPublish(topic, payload);
    }


    public void triggerVPVDisconected(){
        String topic = "";
        String payload = "{\"expiration\":"+(System.currentTimeMillis()/1000-600)+"}";
        mqttPublish(topic, payload);
    }

    public void triggerVPVConnected(){
        String topic = "";
        String payload = "{\"expiration\":"+(System.currentTimeMillis()/1000+120)+"}";
        mqttPublish(topic, payload);
    }
    @Step("Sending payload to VPV equipment")
    public void triggerVPVAlarmCount(){
        String topic =  AssembledEquipments.equipmentVpvData;
        String payload =PayloadVPV.newBuilder().setId(AssembledEquipments.equipmentVpv).setMaxDistanceMain(91).initialize();
        String payloadNormal = PayloadVPV.newBuilder().setId(AssembledEquipments.equipmentVpv).initialize();        mqttPublish(topic, payloadNormal);
        mqttPublish(topic, payloadNormal);
        mqttPublish(topic, payload);
        mqttPublish(topic, payloadNormal);
    }
    @Step("Sending payload to VPV equipment")
    public void triggerVPVAbortCount(){
        String topic = AssembledEquipments.equipmentVpvData;
        String payload =PayloadVPV.newBuilder().setId(AssembledEquipments.equipmentVpv).setMaxDistanceMain(170).initialize();
        String payloadNormal = PayloadVPV.newBuilder().setId(AssembledEquipments.equipmentVpv).initialize();
        mqttPublish(topic, payloadNormal);
        mqttPublish(topic, payload);
        mqttPublish(topic, payloadNormal);
    }

    public void triggerGPVLong(){
        String topic = AssembledEquipments.equipmentGpvData;
        String payload = PayloadGPV.newBuilder().setDistance(240).setMultiDataStreamId(AssembledEquipments.equipmentGpvMultiDatastreamId).setAlarm(true).initialize();
        String payloadNormal = PayloadGPV.newBuilder().setDistance(1).setMultiDataStreamId(AssembledEquipments.equipmentGpvMultiDatastreamId).setAlarm(false).initialize();
        for (int i = 0; i<5; i++){
            mqttPublish(topic, payloadNormal);
            mqttPublish(topic, payload);
            mqttPublish(topic, payloadNormal);
        }
    }

    public void triggerGPV(){
        String topic = AssembledEquipments.equipmentGpvData;
        String payload = PayloadGPV.newBuilder().setDistance(240).setMultiDataStreamId(AssembledEquipments.equipmentGpvMultiDatastreamId).setAlarm(true).initialize();
        String payloadNormal = PayloadGPV.newBuilder().setDistance(1).setMultiDataStreamId(AssembledEquipments.equipmentGpvMultiDatastreamId).setAlarm(false).initialize();
        mqttPublish(topic, payloadNormal);
        mqttPublish(topic, payload);
        mqttPublish(topic, payloadNormal);
    }

    public void readVPVD11(){
        String topic = AssembledEquipments.equipmentVpvData;
        mqttSubscribe(59000, topic);

    }

    public void readGPV(){
        String topic = AssembledEquipments.equipmentGpvData;
        mqttSubscribe(59000, topic);
    }
}
