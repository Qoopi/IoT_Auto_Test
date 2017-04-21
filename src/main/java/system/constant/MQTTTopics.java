package system.constant;

/**
 * Created by user on 19.04.2017.
 */
public enum MQTTTopics {
    someTopic("Heartbeat/U000001/MRL/Lab/ATMRobot/002"),
    Thing000011i1Heart("Heartbeat/U000001/ODS/Lab/ATMRobot/001"),
    Thing000011i1Data("Heartbeat/U000001/ODS/Lab/ATMRobot/001");

    private final String value;

    MQTTTopics(String s) {
        value = s;
    }

    public String getValue(){
        return value;
    }
}
