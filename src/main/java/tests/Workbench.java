package tests;

import com.jayway.restassured.response.Response;
import mechanics.api.ListenerAPI;
import mechanics.api.MQTTManagerAPI;
import mechanics.api.RequestManagerAPI;
import mechanics.api.json.GlobalSettingsRequest;
import mechanics.api.json.GlobalSettingsResponse;
import mechanics.system.aws.SignAWSv4;
import mechanics.system.constant.AssembledEquipments;
import mechanics.system.constant.AssembledUrls;
import mechanics.system.constant.HTTPMethod;
import mechanics.system.http.RequestSender;
import mechanics.system.mqtt.PayloadGPV;
import mechanics.system.mqtt.PayloadVPV;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by user on 19.04.2017.
 */
@Listeners(ListenerAPI.class)
public class Workbench {

    @Test
    public void testGlobalAck(){
        String url = AssembledUrls.globalSettings;
        RequestManagerAPI requestSender = new RequestManagerAPI();
        String body = GlobalSettingsRequest.newBuilder().initialize();
        GlobalSettingsResponse globalSettingsResponse = new GlobalSettingsResponse();
        requestSender.sendAmazonRequest("PUT", url, body);

        String body1 = GlobalSettingsRequest.newBuilder().setAcknowledged(31).initialize();
        requestSender.sendAmazonRequest("PUT", url, body1);

        String body3 = requestSender.sendAmazonRequest("GET", url).asString();
        globalSettingsResponse.parse(body3);
        Assert.assertTrue(31==globalSettingsResponse.getAcknowledged());
    }

//    @Test
    public void testData(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.checkEquipmentDataGPV();
//        requestManagerAPI.checkEquipmentDataVPV();
    }

//    @Test
    public void testHeartbeat(){
        String topic = "Heartbeat/U000001/OSS/Lab/FGW/Thing-000025";
        String payload = "{\"expiration\":"+(System.currentTimeMillis()/1000-600)+"}";
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        mqttManagerAPI.mqttPublish(topic, payload);
    }

//    @Test
    public void testHeartbeatConnected(){
        String topic = "Heartbeat/U000001/OSS/Lab/FGW/Thing-000025";
        String payload = "{\"expiration\":"+(System.currentTimeMillis()/1000+120)+"}";
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        mqttManagerAPI.mqttPublish(topic, payload);
    }

//    @Test
    public void testWidget(){
        String topic = AssembledEquipments.equipmentGpvData;
        String payload = PayloadGPV.newBuilder().setMultiDataStreamId(AssembledEquipments.equipmentGpvMultiDatastreamId).setAlarm(true).initialize();
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        mqttManagerAPI.mqttPublish(topic, payload, 5);
    }

//    @Test
    public void subscribe(){
        String topic = "Heartbeat/U000001/OSS/Lab/FGW/Thing-090175";
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        mqttManagerAPI.mqttSubscribe(62000, topic);
    }


//    @Test
    public void testRoutes() {
        String[] routes = {
                "authentication/logout",
                "authentication/refresh",
                "authentication/refresh/testapi",
                "dashboard",
                "equipment",
                "equipment_admin",
                "equipment_models",
                "frequencytoes",
                "global_settings",
                "helloRestconf",
                "menu",
                "notification",
                "profile",
                "report",
                "rule",
                "syncwithis",
                "templates",
                "testassumerole",
                "user"
        };
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        requestManagerAPI.getRoute(routes);
    }


//    @Test
    public void setThresholdVPV(){
        RequestManagerAPI requestManagerAPI = new RequestManagerAPI();
        Response response = requestManagerAPI.sendAmazonRequest("GET", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/equipment_admin");
        String newBody = requestManagerAPI.changeThresholdVPV(response.asString(), "Thing-000011-i1", 90, 95, 120, 125);
        requestManagerAPI.sendAmazonRequest("PUT", "https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/equipment_admin", newBody);
    }


//    @Test
    public void builder(){
        String  payloadVPV = PayloadVPV.newBuilder().setAbnormalVibrationMain(666).setId("someid").initialize();
        System.out.println(payloadVPV);
//        String payload2 = PayloadVPV.newBuilder().setId("ohCock").setMaxDistanceBlower(6666).initialize();
//        System.out.println(payload2);
    }
//    @Test
    public void gpvbuilder(){
        String payloadGPV = PayloadGPV.newBuilder().setMultiDataStreamId("111").setDistance(666).initialize();
        System.out.println(payloadGPV);
    }

    public void test3(){
        Assert.assertTrue(false);
    }

//    @Test
    public void test1(){
        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
        mqttManagerAPI.triggerGPVLong();
    }

//    @Test
//    public void testMqttPublish(){
//        MQTTManagerAPI mqttManagerAPI = new MQTTManagerAPI();
//        mqttManagerAPI.triggerVPVAbnormalVibration();
//        mqttManagerAPI.triggerGPVLong();
//    }

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

//    @Test
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
