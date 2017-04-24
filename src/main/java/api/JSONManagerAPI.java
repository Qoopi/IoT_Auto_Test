package api;

import system.http.JSONHandler;

/**
 * Created by user on 20.04.2017.
 */
public class JSONManagerAPI extends JSONHandler{
    private final String equipmentVPV  = "Thing-000011-i1";
    private final String equipmentGPV  = "Thing-090154-0";


    public String notificationRuleCreateAbnormalVibrationVPVPumpD11(){
        return notificationRuleCreateJSON("Abnormal Vibration VPV","Pump D11",0,equipmentVPV,0,"",">=",30,0,1).toString();
    }

    public String notificationRuleCreateAlarmCountGPV(){
        return notificationRuleCreateJSON("Alarm Count GPV","BUC ARTRobot",3,equipmentGPV, 0,"",">=",1,1, 0).toString();
    }

    public String notificationRuleCreateAlarmCountVPV(){
        return notificationRuleCreateJSON("Alarm Count VPV","PUMP D11",3,equipmentVPV, 0,"",">=",1,1, 0).toString();
    }

    public String notificationRuleCreateAbortsCountVPV(){
        return notificationRuleCreateJSON("Aborts Count VPV","PUMP D11",3,equipmentVPV, 0,"",">=",1,1, 0).toString();
    }

    public String notificationRuleCreateDisconnectedVPV(){
        return notificationRuleCreateJSON("Disconnected Equipment VPV","PUMP D11",4,equipmentVPV, 0,"0","",0,0, 0).toString();
    }

    public String notificationRuleCreateDisconnectedGPV(){
        return notificationRuleCreateJSON("Disconnected Equipment GPV","BUC ARTRobot",4,equipmentGPV, 0,"0","",0,0, 0).toString();
    }

    public String notificationRuleCreateConnectedVPV(){
        return notificationRuleCreateJSON("Disconnected Equipment VPV","PUMP D11",4,equipmentVPV, 0,"1","",0,0, 0).toString();
    }

    public String notificationRuleCreateConnectedGPV(){
        return notificationRuleCreateJSON("Disconnected Equipment GPV","BUC ARTRobot",4,equipmentGPV, 0,"1","",0,0, 0).toString();
    }

    public String notificationRuleCreateEveryWarningVPV(){
        return notificationRuleCreateJSON("Every Warning VPV", "PUMP D11", 8, equipmentVPV, 0, "", ">=", 0, 0, 0).toString();
    }

    public String equipmentDisconnectVPV(){
        return equipmentOnOff(equipmentVPV,false);
    }
    public String equipmentConnectVPV(){
        return equipmentOnOff(equipmentVPV,true);
    }
    public String equipmentDisconnectGPV(){
        return equipmentOnOff(equipmentGPV,false);
    }
    public String equipmentConnectGPV(){
        return equipmentOnOff(equipmentGPV,true);
    }

}
