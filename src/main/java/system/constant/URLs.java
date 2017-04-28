package system.constant;

/**
 * Created by user on 19.04.2017.
 */
public enum URLs {
    HTTPS("https://"),
    ApiGateway("60sglz9l5h.execute-api.us-east-1.amazonaws.com"),
    HttpsApiGateway(HTTPS.getValue()+ApiGateway.getValue()),
    NotificationRule(HttpsApiGateway.getValue()+"/dev/rule"),
    NotificationUnread(HttpsApiGateway.getValue()+"/dev/notification?status=unread"),
    Notification(HttpsApiGateway.getValue()+"/dev/notification"),
    EquipmentAdmin(HttpsApiGateway.getValue()+"/dev/equipment_admin"),
    Report(HttpsApiGateway.getValue()+"/dev/report"),
    AuthenticationRefresh(HttpsApiGateway.getValue()+"/dev/authentication/refresh"),

    MQTTGateway("a2awmps9ermju9.iot.us-east-1.amazonaws.com"),
    Dashboard("dashboard.dev.iotsyst.com");

    private final String value;

    URLs(String s) {
        value = s;
    }

    public String getValue(){
        return value;
    }

    public String getValue(String suffix){
        return value+"/"+suffix;
    }
}
