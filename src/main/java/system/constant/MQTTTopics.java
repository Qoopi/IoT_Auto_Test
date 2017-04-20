package system.constant;

/**
 * Created by user on 19.04.2017.
 */
public enum MQTTTopics {
    someTopic("Heartbeat/U000001/MRL/Lab/ATMRobot/002");

    private final String value;

    MQTTTopics(String s) {
        value = s;
    }

    public String getValue(){
        return value;
    }
}
