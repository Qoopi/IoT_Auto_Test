package api;

import com.google.gson.JsonObject;
import org.testng.annotations.Test;
import system.http.JSONHandler;

/**
 * Created by user on 20.04.2017.
 */
public class JSONManagerAPI extends JSONHandler{


    public String notificationRuleCreateVPVPumpD11(){

        return notificationRuleCreateJSON("AbnormalVibrationVPV","Pump D11",0,"Thing-000011-i1",0,"0",">=",0,0,1).toString();
    }

    @Test
    public void test(){
        System.out.println(notificationRuleCreateVPVPumpD11());
    }

}
