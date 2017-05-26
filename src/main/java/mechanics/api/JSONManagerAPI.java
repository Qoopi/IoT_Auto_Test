package mechanics.api;

import mechanics.system.constant.AssembledEquipments;
import mechanics.system.http.JSONHandler;
import ru.yandex.qatools.allure.annotations.Step;

import static mechanics.system.constant.EmailInbox.*;

/**
 * Created by user on 20.04.2017.
 */
public class JSONManagerAPI extends JSONHandler{
    private static String thingVpv = AssembledEquipments.equipmentVpv;
    private static String thingGpv = AssembledEquipments.equipmentGpv;



    @Step("Creating JSON for Abnormal Vibration rule,channel: Any, Abort.")
    public String jsonRuleAbnormalVibrationVPVAnyAbort(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleAbnormalVibrationsVPV.getMessage(),
                "Auto tests rule",
                0,
                0,
                thingVpv,
                0,
                "",
                ">=",
                30,
                0,
                1
        ).toString();
    }
    @Step("Creating JSON for Abnormal Vibration rule,channel: Any, Alarm.")
    public String jsonRuleAbnormalVibrationVPVAnyAlarm(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleAbnormalVibrationsVPV.getMessage(),
                "Auto tests rule",
                0,
                0,
                thingVpv,
                1,
                "",
                ">=",
                30,
                0,
                1
        ).toString();
    }
    @Step("Creating JSON for Abnormal Vibration rule,channel: Main, Abort.")
    public String jsonRuleAbnormalVibrationVPVMainAbort(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleAbnormalVibrationsVPV.getMessage(),
                "Auto tests rule",
                0,
                1,
                thingVpv,
                0,
                "",
                ">=",
                30,
                0,
                1
        ).toString();
    }
    @Step("Creating JSON for Abnormal Vibration rule,channel: Main, Alarm.")
    public String jsonRuleAbnormalVibrationVPVMainAlarm(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleAbnormalVibrationsVPV.getMessage(),
                "Auto tests rule",
                0,
                1,
                thingVpv,
                1,
                "",
                ">=",
                30,
                0,
                1
        ).toString();
    }
    @Step("Creating JSON for Abnormal Vibration rule,channel: Blower,Abort.")
    public String jsonRuleAbnormalVibrationVPVBlowerAbort(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleAbnormalVibrationsVPV.getMessage(),
                "Auto tests rule",
                0,
                2,
                thingVpv,
                0,
                "",
                ">=",
                30,
                0,
                1
        ).toString();
    }
    @Step("Creating JSON for Abnormal Vibration rule,channel: Blower,Alarm.")
    public String jsonRuleAbnormalVibrationVPVBlowerAlarm(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleAbnormalVibrationsVPV.getMessage(),
                "Auto tests rule",
                0,
                2,
                thingVpv,
                0,
                "",
                ">=",
                30,
                0,
                1
        ).toString();
    }
    @Step("Creating JSON for Number of Alarms above threshold on GPV equipment.")
    public String jsonRuleAlarmCountGPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleNumberOfAlarms.getMessage(),
                "Auto tests rule",
                3,
                "0",
                thingGpv,
                "",
                "",
                ">=",
                1,
                1,
                0
        ).toString();
    }
    @Step("Creating JSON for Number of Alarms above threshold on VPV equipment.")
    public String jsonRuleAlarmCountVPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleNumberOfAlarms.getMessage(),
                "Auto tests rule",
                3,
                "0",
                thingVpv,
                "",
                "",
                ">=",
                1,
                1,
                0
        ).toString();
    }
    @Step("Creating JSON for Number of Aborts above threshold on Pump equipment.")
    public String jsonRuleAbortsCountVPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleNumberOfAborts.getMessage(),
                "Auto tests rule",
                2,
                "0",
                thingVpv,
                "",
                "",
                ">=",
                1,
                1,
                0
        ).toString();
    }
    @Step("Creating JSON for Disconnected rule for VPV equipment.")
    public String jsonRuleDisconnectedVPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleDisconnectedVPV.getMessage(),
                "Auto tests rule",
                4,
                0,
                thingVpv,
                0,
                "0",
                "",
                0,
                0,
                0
        ).toString();
    }
    @Step("Creating JSON for Disconnected rule for BUC ARTRobot.")
    public String jsonRuleDisconnectedGPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleDisconnectedGPV.getMessage(),
                "Auto tests rule",
                4,
                0,
                thingGpv,
                0,
                "0",
                "",
                0,
                0,
                0
        ).toString();
    }
    @Step("Creating JSON for Connected rule for VPV equipment.")
    public String jsonRuleConnectedVPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleConnectedVPV.getMessage(),
                "Auto tests rule",
                4,
                0,
                thingVpv,
                0,
                "1",
                "",
                0,
                0,
                0
        ).toString();
    }
    @Step("Creating JSON for Connected rule for GPV equipment.")
    public String jsonRuleConnectedGPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleConnectedGPV.getMessage(),
                "Auto tests rule",
                4,
                0,
                thingGpv,
                0,
                "1",
                "",
                0,
                0,
                0
        ).toString();
    }
    @Step("Creating JSON for Every Warning rule for VPV equipment.")
    public String jsonRuleEveryWarningVPVAbort(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleEveryWarningVPV.getMessage(),
                "Auto tests rule",
                8,
                0,
                thingVpv,
                0,
                "",
                ">=",
                0,
                0,
                0
        ).toString();
    }
    @Step("Creating JSON for Every Warning rule for VPV equipment.")
    public String jsonRuleEveryWarningVPVAlarm(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleEveryWarningVPV.getMessage(),
                "Auto tests rule",
                8,
                0,
                thingVpv,
                1,
                "",
                ">=",
                0,
                0,
                0
        ).toString();
    }
    @Step("Creating JSON for Every Warning rule for GPV equipment.")
    public String jsonRuleEveryWarningGPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleEveryWarningGPV.getMessage(),
                "Auto tests rule",
                9,
                0,
                thingGpv,
                0,
                "",
                ">=",
                0,
                0,
                0
        ).toString();
    }


    public String jsonEquipmentDisconnectVPV(){
        return equipmentOnOff(thingVpv,false);
    }
    public String jsonEquipmentConnectVPV(){
        return equipmentOnOff(thingVpv,true);
    }
    public String jsonEquipmentDisconnectGPV(){
        return equipmentOnOff(thingGpv,false);
    }
    public String jsonEquipmentConnectGPV(){
        return equipmentOnOff(thingGpv,true);
    }

    private String reportTemplateId = "Vacuum-Pump-Vibration-Report---Optimized-for-Printing---Weekly";
    private String reportTemplateName = "Vacuum-Pump-Vibration-Report-List---Optimized-for-Printing---Weekly";

    public String JSONReportCreate(){
        return reportCreate(reportTemplateId, thingVpv, reportTemplateName).toString();
    }

    public String JSONReportSendNow(String id){
        return reportSendNow(id, reportTemplateId, thingVpv, reportTemplateName).toString();
    }

    public String JSONReportDelete(){
        System.out.println("DELETING OF SKEDLER RULERS IS NOT IMPLEMENTED");
        return null;
    }

    private static final String Name = "Automatically Created Dashboard";
    private static final String Description = "You should not see this one";
    public String jsonDashboardCreateVPVCanvas(){
        int dashboardType = 7;
        String equipmentId = thingVpv;
        String name = Name;
        String description = Description;
        return dashboardCreate(dashboardType, equipmentId, name, description).toString();
    }

    public String jsonDashboardCreateVPVKibana(){
        int dashboardType = 6;
        String equipmentId = thingVpv;
        String name = Name;
        String description = Description;
        return dashboardCreate(dashboardType, equipmentId, name, description).toString();
    }
    public String jsonDashboardCreateGPVKibana025(){
        int dashboardType = 4;
        String equipmentId = thingGpv;
        String name = Name;
        String description = Description;
        return dashboardCreate(dashboardType, equipmentId, name, description).toString();
    }
    public String jsonDashboardCreateGPVKibana0255(){
        int dashboardType = 5;
        String equipmentId = thingGpv;
        String name = Name;
        String description = Description;
        return dashboardCreate(dashboardType, equipmentId, name, description).toString();
    }
    public String jsonDashboardCreateGPVCanvas025(){
        int dashboardType = 8;
        String equipmentId = thingGpv;
        String name = Name;
        String description = Description;
        return dashboardCreate(dashboardType, equipmentId, name, description).toString();
    }
    public String jsonDashboardCreateGPVCanvas0255(){
        int dashboardType = 9;
        String equipmentId = thingGpv;
        String name = Name;
        String description = Description;
        return dashboardCreate(dashboardType, equipmentId, name, description).toString();
    }

}
