import api.ListenerAPI;
import api.MQTTManagerAPI;
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
        mqttManagerAPI.triggerGPV();
//        mqttManagerAPI.triggerGPV2();
    }
}
