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
    public String notificationRuleCreateDisconnectedVPV(){
        return notificationRuleCreateJSON("Disconnected Equipment","PUMP D11",4,"Thing-000011-i1", Integer.parseInt(null),"0","",0,0, Integer.parseInt(null)).toString();
    }
    public String notificationRuleCreateDisconnectedGPV(){
        return notificationRuleCreateJSON("Disconnected Equipment","BUC ARTRobot",4,"Thing-090154-0", Integer.parseInt(null),"0","",0,0, Integer.parseInt(null)).toString();
    }
    public String notificationRuleCreateConnectedVPV(){
        return notificationRuleCreateJSON("Disconnected Equipment","PUMP D11",4,"Thing-000011-i1", Integer.parseInt(null),"1","",0,0, Integer.parseInt(null)).toString();
    }
    public String notificationRuleCreateConnectedGPV(){
        return notificationRuleCreateJSON("Disconnected Equipment","BUC ARTRobot",4,"Thing-090154-0", Integer.parseInt(null),"1","",0,0, Integer.parseInt(null)).toString();
    }

    public  String disconnectedVPV(){
        return equipmentOnOff("Thing-000011-i1",false).toString();
    }
    public  String connectedVPV(){
        return equipmentOnOff("Thing-000011-i1",true).toString();
    }
    public  String disconnectedGPV(){
        return equipmentOnOff("Thing-090154-0",false).toString();
    }
    public  String connectedGPV(){
        return equipmentOnOff("Thing-090154-0",true).toString();
    }
}
