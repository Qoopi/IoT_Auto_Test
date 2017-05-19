package tests;

import mechanics.api.ListenerAPI;
import mechanics.api.MQTTManagerAPI;
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

    @Test
    public void testMqttPublish(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        mqttManagerAPI.triggerVPVAbnormalVibration();
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
}
