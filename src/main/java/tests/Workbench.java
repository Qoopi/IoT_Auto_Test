package tests;

import mechanics.api.ListenerAPI;
import mechanics.api.MQTTManagerAPI;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 19.04.2017.
 */
@Listeners(ListenerAPI.class)
public class Workbench {


    @Test
    public void test1(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        mqttManagerAPI.triggerGPVLong();
//        mqttManagerAPI.triggerGPV();
    }

//    @Test
    public void test11(){
        double equipCounter = 001;
        System.out.println(equipCounter);
        equipCounter++;
        System.out.println(equipCounter);
    }
}
