package mechanics.api;

import ru.yandex.qatools.allure.annotations.Step;
import mechanics.system.mqtt.MQTTConnector;

import static mechanics.system.constant.MQTTTopics.*;

/**
 * Created by user on 21.04.2017.
 */
public class MQTTManagerAPI extends MQTTConnector {
    @Step("Sending payload to Pump D11")
    public void triggerVPVD11AbnormalVibration(){
        String topic = VPVD11Data.getValue();
        String payload = "{\"device\":{\"id\":\"Thing-000011-i1\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":115},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":40},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":11.9},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":6666,\"freq\":1000},{\"distance\":6666,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":6666,\"freq\":1000},{\"distance\":6666,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":false,\"failure\":true,\"state\":false},\"serialNum\":0,\"timestamp\":1492776189}}";
        mqttPublish(topic, payload);
    }

    public void triggerVPVDisconected(){
        String topic = VPVD11Heartbeat.getValue();
        String payload = "{\"expiration\":"+(System.currentTimeMillis()/1000-600)+"}";
        mqttPublish(topic, payload);
    }

    public void triggerVPVConnected(){
        String topic = VPVD11Heartbeat.getValue();
        String payload = "{\"expiration\":"+(System.currentTimeMillis()/1000+120)+"}";
        mqttPublish(topic, payload);
    }
    @Step("Sending payload to Pump D11")
    public void triggerVPVAlarmCount(){
        String topic = VPVD11Data.getValue();
        String payload = "{\"device\":{\"id\":\"Thing-000011-i1\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":115},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":40},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":11.9},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":99,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":false,\"failure\":true,\"state\":true},\"serialNum\":0,\"timestamp\":1492776189}}";
        String payloadNormal = "{\"device\":{\"id\":\"Thing-000011-i1\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":40},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":11.9},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":false,\"failure\":true,\"state\":false},\"serialNum\":0,\"timestamp\":1492776189}}";
        mqttPublish(topic, payloadNormal);
        mqttPublish(topic, payload);
        mqttPublish(topic, payloadNormal);
    }
    @Step("Sending payload to Pump D11")
    public void triggerVPVAbortCount(){
        String topic = VPVD11Data.getValue();
        String payload = "{\"device\":{\"id\":\"Thing-000011-i1\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":115},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":140},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":111.9},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":250,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":true,\"failure\":true,\"state\":false},\"serialNum\":0,\"timestamp\":1492776189}}";
        String payloadNormal = "{\"device\":{\"id\":\"Thing-000011-i1\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":40},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":11.9},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":false,\"failure\":true,\"state\":false},\"serialNum\":0,\"timestamp\":1492776189}}";
        mqttPublish(topic, payloadNormal);
        mqttPublish(topic, payload);
        mqttPublish(topic, payloadNormal);
    }

    public void triggerGPV(){
        String topic = "Data/U000001/OSS/Lab/Misc/Thing00099/v1.0/MultiDatastreams(233)";
        String payload = "{\n" +
                "  \"result\": [\n" +
                "    true,\n" +
                "    266\n" +
                "  ],\n" +
                "  \"resultTime\": \"2017-05-15T12:36:15\",\n" +
                "  \"MultiDatastream\": {\n" +
                "    \"@iot.id\": 233,\n" +
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
        for (int i = 0; i<3; i++){
            mqttPublish(topic, payload);
        }
    }

    public void triggerGPV2(){
        String topic = "Data/UID/LID/GID/TID/1/v1.0/Datastreams(529)";
        String payload = "{\"result\":true,\"resultTime\":\"2017-05-03T07:23:31\",\"Datastream\":{\"@iot.id\":530,\"ObservedProperty\":{\"@iot.id\":2}}}";
//        String payload = "{\"result\":20,\"resultTime\":\"2017-05-03T07:52:21\",\"Datastream\":{\"@iot.id\":529}}";
        mqttPublish(topic, payload);
        mqttPublish(topic, payload);
        mqttPublish(topic, payload);
        mqttPublish(topic, payload);
    }

    public void readVPVD11(){
        String topic = VPVD11Heartbeat.getValue();
        mqttSubscribe(59000, topic);

    }

    public void readGPV(){
        String topic = GPVBUCData.getValue();
        mqttSubscribe(59000, topic);
    }
}
