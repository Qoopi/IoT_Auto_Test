package mechanics.system.constant;

/**
 * Created by user on 19.04.2017.
 */
public enum ArchivedMQTTTopics {
    VPVD11Heartbeat("Heartbeat/U000001/ODS/Lab/ATMRobot/001"),
    VPVD11Data("Data/U000001/ODS/Lab/ATMRobot/001/VPV/STA"),
    GPVBUCData("Data/U0000012454/BUC/Lab/00012454/ATMRobot/GPV/STA");

    private final String value;

    ArchivedMQTTTopics(String s) {
        value = s;
    }

    public String getValue(){
        return value;
    }
}
