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
    Dashboard(HttpsApiGateway.getValue()+"/dev/dashboard"),
    Chart(HttpsApiGateway.getValue("/dev/chart")),

    MQTTGateway("a2awmps9ermju9.iot.us-east-1.amazonaws.com"),
    DevDashboardApp("dashboard.dev.iotsyst.com"),
    HttpsDashboardDev(HTTPS.getValue()+"dashboard.dev.iotsyst.com"),


    LoadDashboardApp("d12pl6fd8zs84c.cloudfront.net"),
    HttpsLoadDashboardApp(HTTPS.getValue()+"d12pl6fd8zs84c.cloudfront.net"),
    LoadApiGateway("oshk5hrphl.execute-api.eu-west-1.amazonaws.com"),
    HttpsLoadApiGateway(HTTPS.getValue()+LoadApiGateway.getValue()),
    LoadNotificationRule(HttpsLoadApiGateway.getValue()+"/loadtest/rule"),
    LoadNotificationUnread(HttpsLoadApiGateway.getValue()+"/loadtest/notification?status=unread"),
    LoadNotification(HttpsLoadApiGateway.getValue()+"/loadtest/notification"),
    LoadEquipmentAdmin(HttpsLoadApiGateway.getValue()+"/loadtest/equipment_admin"),
    LoadReport(HttpsLoadApiGateway.getValue()+"/loadtest/report"),
    LoadAuthenticationRefresh(HttpsLoadApiGateway.getValue()+"/loadtest/authentication/refresh"),
    LoadDashboard(HttpsLoadApiGateway.getValue()+"/loadtest/dashboard"),
    LoadChart(HttpsLoadApiGateway.getValue("/loadtest/chart")),;

    private final String value;

    URLs(String s) {
        value = s;
    }

    public String getValue(){
        return value;
    }

    public String getValue(String suffix){
        return value+suffix;
    }
}
