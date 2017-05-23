package tests;

import mechanics.api.ListenerAPI;
import mechanics.api.MQTTManagerAPI;
import mechanics.api.RequestManagerAPI;
import mechanics.system.aws.SignAWSv4;
import mechanics.system.constant.HTTPMethod;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 19.04.2017.
 */
@Listeners(ListenerAPI.class)
public class Workbench {


    public void test3(){
        Assert.assertTrue(false);
    }

//    @Test
    public void test1(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        mqttManagerAPI.triggerGPVLong();
    }

//    @Test
    public void testMqttPublish(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        mqttManagerAPI.triggerVPVAbnormalVibration();
        mqttManagerAPI.triggerGPVLong();
    }

//    @Test
    public void testMqttSubscribe(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        mqttManagerAPI.readGPV();
    }

//    @Test
    public void test11(){
        double equipCounter = 001;
        System.out.println(equipCounter);
        equipCounter++;
        System.out.println(equipCounter);
    }

    @Test
    public void authRefresh(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        SignAWSv4 signAWSv4 = new SignAWSv4();
        for (int i = 0; i<50; i++) {
            String url = "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/authentication/refresh";
            requestManagerAPI.createEmptyRequestWithHeaders(signAWSv4.allHeaders(HTTPMethod.GET.getValue(), url)).get(url);
            requestManagerAPI.dashboardCreate(requestManagerAPI.jsonDashboardCreateGPVKibana025());
        }
    }

    public void checkAuthRefresh(){

    }
}
