package api;

import system.constant.MQTTTopics;
import system.mqtt.MQTTConnector;

/**
 * Created by user on 21.04.2017.
 */
public class MQTTManagerAPI extends MQTTConnector {

    public void triggerVPVD11AbnormalVibration(){
        String topic = MQTTTopics.VPVD11Data.getValue();
        String payload = "{\"device\":{\"id\":\"Thing-000011-i1\",\"model\":\"r2d4\",\"name\":\"Pump D11\"},\"vibration\":{\"accelerometer\":[{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":115},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":0,\"distance\":40},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":11.9},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":15},\"userDefined\":[{\"distance\":666,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]},{\"filteredMax\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"filteredRms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"freqAtMaxDistance\":6953,\"max\":{\"abortLimit\":90,\"abortState\":false,\"alarmLimit\":30,\"alarmState\":false,\"distance\":0},\"pumpFailureState\":true,\"rms\":{\"abortLimit\":0,\"abortState\":false,\"alarmLimit\":0,\"alarmState\":false,\"distance\":0},\"userDefined\":[{\"distance\":0,\"freq\":1000},{\"distance\":0,\"freq\":2000},{\"distance\":0,\"freq\":3000},{\"distance\":0,\"freq\":4000},{\"distance\":0,\"freq\":5000},{\"distance\":0,\"freq\":6000},{\"distance\":0,\"freq\":7000},{\"distance\":0,\"freq\":8000},{\"distance\":0,\"freq\":9000},{\"distance\":0,\"freq\":10000}]}],\"alarm\":{\"abort\":false,\"failure\":true,\"state\":false},\"serialNum\":0,\"timestamp\":1492776189}}";
        mqttPublish(topic, payload);
    }

    public void triggerVPVDisconected(){
        String topic = MQTTTopics.VPVD11Heartbeat.getValue();
        String payload = "{\"expiration\":1482111111}";
        mqttPublish(topic, payload);
    }

    public void readVPVD11(){
        String topic = "Heartbeat/U000001/ODS/Lab/ATMRobot/001";
        mqttSubscribe(59000, topic);

    }

    public void readGPV(){
        String topic = MQTTTopics.GPVBUCData.getValue();
        mqttSubscribe(59000, topic);
    }
}
