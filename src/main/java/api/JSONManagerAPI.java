package api;

import system.http.JSONHandler;

/**
 * Created by user on 20.04.2017.
 */
public class JSONManagerAPI extends JSONHandler{


    public String notificationRuleCreateAbnormalVibrationVPVPumpD11(){
        return notificationRuleCreateJSON("I HATE YOU BITCH","Pump D11",0,"Thing-000011-i1",0,"",">=",30,0,1).toString();
    }

    public String notificationRuleCreateAlarmCountGPV(){
        return notificationRuleCreateJSON("Alarm Count GPV","BUC ARTRobot",3,"Thing-090154-0", Integer.parseInt(null),"",">=",1,1, Integer.parseInt(null)).toString();
    }

    public String notificationRuleCreateAlarmCountVPV(){
        return notificationRuleCreateJSON("Alarm Count VPV","PUMP D11",3,"Thing-000011-i1", Integer.parseInt(null),"",">=",1,1, Integer.parseInt(null)).toString();
    }
    public String notificationRuleCreateAbortsCountVPV(){
        return notificationRuleCreateJSON("Aborts Count VPV","PUMP D11",3,"Thing-000011-i1", Integer.parseInt(null),"",">=",1,1, Integer.parseInt(null)).toString();
    }
    public String notificationRuleCreateDisconnected(){
        return notificationRuleCreateJSON("Disconnected Equipment","PUMP D11",4,"Thing-000011-i1", Integer.parseInt(null),"0","",0,0, Integer.parseInt(null)).toString();
    }
    public String notificationRuleCreateConnected(){
        return notificationRuleCreateJSON("Disconnected Equipment","PUMP D11",4,"Thing-000011-i1", Integer.parseInt(null),"1","",0,0, Integer.parseInt(null)).toString();
    }
}
