package mechanics.system.constant;

import static mechanics.system.constant.Routes.*;

/**
 * Created by Alex Storm on 16.05.2017.
 */
public class AssembledUrls {
    public static String apiUrl;
    public static String apiUrlMin;
    public static String redirectClientURI;
    public static String iotEndpoint;

    public static String notificationRule;
    public static String notificationUnread;
    public static String notification;
    public static String equipmentAdmin;
    public static String report;
    public static String authenticationRefresh;
    public static String dashboard;
    public static String chart;

    public void assemble(){
        notificationRule = apiUrl+NotificationRule.getValue();
        notificationUnread = apiUrl+NotificationUnread.getValue();
        notification = apiUrl+Notification.getValue();
        equipmentAdmin = apiUrl+EquipmentAdmin.getValue();
        report = apiUrl+Report.getValue();
        authenticationRefresh = apiUrl+AuthenticationRefresh.getValue();
        dashboard = apiUrl+Dashboard.getValue();
        chart = apiUrl+Chart.getValue();
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public void setApiUrlMin(String apiUrlMin) {
        this.apiUrlMin = apiUrlMin;
    }

    public void setRedirectClientURI(String redirectClientURI) {
        this.redirectClientURI = redirectClientURI;
    }

    public void setIotEndpoint(String iotEndpoint) {
        this.iotEndpoint = iotEndpoint;
    }


}