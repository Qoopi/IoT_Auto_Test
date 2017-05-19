package mechanics.api;

import mechanics.system.constant.AssembledEquipments;
import ru.yandex.qatools.allure.annotations.Step;
import mechanics.system.mqtt.MQTTConnector;


/**
 * Created by user on 21.04.2017.
 */
public class MQTTManagerAPI extends MQTTConnector {
    @Step("Sending payload to Pump D11")
    public void triggerVPVAbnormalVibration(){
        String topic = AssembledEquipments.equipmentVpvData;
        String payload = "{\"device\":{\"id\":\""+AssembledEquipments.equipmentVpv+"\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":115},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":40},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":165},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":6666,\"freq\":1000},{\"distance\":6666,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":6666,\"freq\":1000},{\"distance\":6666,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":false,\"failure\":true,\"state\":false},\"serialNum\":0,\"timestamp\":1492776189}}";
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
    @Step("Sending payload to Pump D11")
    public void triggerVPVAlarmCount(){
        String topic =  AssembledEquipments.equipmentVpvData;
        String payload = "{\"device\":{\"id\":\""+AssembledEquipments.equipmentVpv+"\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":115},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":40},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":120},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":99,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":false,\"failure\":true,\"state\":true},\"serialNum\":0,\"timestamp\":1492776189}}";
        String payloadNormal = "{\"device\":{\"id\":\""+AssembledEquipments.equipmentVpv+"\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":115},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":40},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":85},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":99,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":false,\"failure\":true,\"state\":true},\"serialNum\":0,\"timestamp\":1492776189}}";
        mqttPublish(topic, payloadNormal);
        mqttPublish(topic, payload);
        mqttPublish(topic, payloadNormal);
    }
    @Step("Sending payload to Pump D11")
    public void triggerVPVAbortCount(){
        String topic = AssembledEquipments.equipmentVpvData;
        String payload = "{\"device\":{\"id\":\""+AssembledEquipments.equipmentVpv+"\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":115},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":40},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":170},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":99,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":false,\"failure\":true,\"state\":true},\"serialNum\":0,\"timestamp\":1492776189}}";
        String payloadNormal = "{\"device\":{\"id\":\""+AssembledEquipments.equipmentVpv+"\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":115},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":40},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":135},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":99,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":false,\"failure\":true,\"state\":true},\"serialNum\":0,\"timestamp\":1492776189}}";
        mqttPublish(topic, payloadNormal);
        mqttPublish(topic, payload);
        mqttPublish(topic, payloadNormal);
    }

    public void triggerGPVLong(){
        String topic = AssembledEquipments.equipmentGpvData;
        String payload = "{\n" +
                "  \"result\": [\n" +
                "    true,\n" +
                "    666\n" +
                "  ],\n" +
                "  \"resultTime\": \"2017-05-18T14:41:45\",\n" +
                "  \"MultiDatastream\": {\n" +
                "    \"@iot.id\": "+AssembledEquipments.equipmentGpvMultiDatastreamId+",\n" +
                "    \"ObservedProperties\": [\n" +
                "      {\n" +
                "        \"@iot.id\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"@iot.id\": 1\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        for (int i = 0; i<5; i++){
            mqttPublish(topic, payload);
        }
    }

    public void triggerGPV(){
        String topic = AssembledEquipments.equipmentGpvData;
        String payload = "{\n" +
                "  \"result\": [\n" +
                "    true,\n" +
                "    6666\n" +
                "  ],\n" +
                "  \"resultTime\": \"2017-05-15T12:36:15\",\n" +
                "  \"MultiDatastream\": {\n" +
                "    \"@iot.id\": "+AssembledEquipments.equipmentGpvMultiDatastreamId+",\n" +
                "    \"ObservedProperties\": [\n" +
                "      {\n" +
                "        \"@iot.id\": 2\n" +
                "      },\n" +
                "      {\n" +
                "        \"@iot.id\": 1\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        mqttPublish(topic, payload);
        mqttPublish(topic, payload);
        mqttPublish(topic, payload);
        mqttPublish(topic, payload);
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
