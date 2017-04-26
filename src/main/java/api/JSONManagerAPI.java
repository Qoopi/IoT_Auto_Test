package api;

import ru.yandex.qatools.allure.annotations.Step;
import system.http.JSONHandler;

import static system.constant.EmailINBOX.*;
import static system.constant.Things.ThingGPVBUC;
import static system.constant.Things.ThingVPV11;

/**
 * Created by user on 20.04.2017.
 */
public class JSONManagerAPI extends JSONHandler{


    @Step("Creating Abnormal Vibration rule on Pump D11.")
    public String JSONRuleAbnormalVibrationVPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleAbnormalVibrationsVPV.getMessage(),
                "Pump D11",
                0,
                ThingVPV11.getValue(),
                0,
                "",
                ">=",
                30,
                0,
                1
        ).toString();
    }
    @Step("Creating rule Number of Alarms above threshold on BUC ARTRobot.")
    public String JSONRuleAlarmCountGPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleNumberOfAlarms.getMessage(),
                "BUC ARTRobot",
                3,
                ThingGPVBUC.getValue(),
                "",
                "",
                ">=",
                1,
                1,
                0
        ).toString();
    }
    @Step("Creating rule Number of Alarms above threshold on Pump D11.")
    public String JSONRuleAlarmCountVPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleNumberOfAlarms.getMessage(),
                "PUMP D11",
                3,
                ThingVPV11.getValue(),
                "",
                "",
                ">=",
                1,
                1,
                0
        ).toString();
    }
    @Step("Creating rule Number of Aborts above threshold on Pump D11.")
    public String JSONRuleAbortsCountVPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleNumberOfAborts.getMessage(),
                "PUMP D11",
                2,
                ThingVPV11.getValue(),
                "",
                "",
                ">=",
                1,
                1,
                0
        ).toString();
    }
    @Step("Creating Disconnected rule for PUMP D11.")
    public String JSONRuleDisconnectedVPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleDisconnectedVPV.getMessage(),
                "PUMP D11",
                4,
                ThingVPV11.getValue(),
                0,
                "0",
                "",
                0,
                0,
                0
        ).toString();
    }
    @Step("Creating Disconnected rule for BUC ARTRobot.")
    public String JSONRuleDisconnectedGPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleDisconnectedGPV.getMessage(),
                "BUC ARTRobot",
                4,
                ThingGPVBUC.getValue(),
                0,
                "0",
                "",
                0,
                0,
                0
        ).toString();
    }
    @Step("Creating Connected rule for PUMP D11.")
    public String JSONRuleConnectedVPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleConnectedVPV.getMessage(),
                "PUMP D11",
                4,
                ThingVPV11.getValue(),
                0,
                "1",
                "",
                0,
                0,
                0
        ).toString();
    }
    @Step("Creating Connected rule for BUC ARTRobot.")
    public String JSONRuleConnectedGPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleConnectedGPV.getMessage(),
                "BUC ARTRobot",
                4,
                ThingGPVBUC.getValue(),
                0,
                "1",
                "",
                0,
                0,
                0
        ).toString();
    }
    @Step("Creating Every Warning rule on Pump D11.")
    public String JSONRuleEveryWarningVPV(){
        return notificationRuleCreateJSON(
                SubjectNotificationRuleEveryWarning.getMessage(),
                "PUMP D11",
                8,
                ThingVPV11.getValue(),
                0,
                "",
                ">=",
                0,
                0,
                0
        ).toString();
    }

    public String JSONEquipmentDisconnectVPV(){
        return equipmentOnOff(ThingVPV11.getValue(),false);
    }
    public String JSONEquipmentConnectVPV(){
        return equipmentOnOff(ThingVPV11.getValue(),true);
    }
    public String JSONEquipmentDisconnectGPV(){
        return equipmentOnOff(ThingGPVBUC.getValue(),false);
    }
    public String JSONEquipmentConnectGPV(){
        return equipmentOnOff(ThingGPVBUC.getValue(),true);
    }

    private String reportTemplateId = "Vacuum-Pump-Vibration-Report---Optimized-for-Printing---Weekly";
    private String reportTemplateName = "Vacuum-Pump-Vibration-Report-List---Optimized-for-Printing---Weekly";

    public String JSONReportCreate(){
        return reportCreate(reportTemplateId, ThingVPV11.getValue(), reportTemplateName).toString();
    }

    public String JSONReportSendNow(String id){
        return reportSendNow(id, reportTemplateId, ThingVPV11.getValue(), reportTemplateName).toString();
    }

    public String JSONReportDelete(){
        return null;
    }
}
