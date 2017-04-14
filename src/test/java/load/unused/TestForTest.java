package load.unused;

import com.amazonaws.services.iot.client.*;
import load.utils.LoadListener;
import load.utils.ThreadLaunchDelayer;
import load.constants.AmazonAPIGateway;
import mqtt.MQTTConnector;
import mqtt.pubSub.TestTopicListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(LoadListener.class)
public class TestForTest {
    private final int threads = 10;

    //    @Test(threadPoolSize = threads, invocationCount = threads)
    public void test() {
        ThreadLaunchDelayer.delay(1000);
        System.out.println(System.currentTimeMillis() + ": hello, i'm your new thread!");
    }

    //    @Test(threadPoolSize = threads, invocationCount = threads)
    public void test1() {
        ThreadLaunchDelayer.delay(1000);
        System.out.println(System.currentTimeMillis() + ": hello, i'm your new thread!");
    }

    //    @Test
    public void sometest() {
        System.out.println(AmazonAPIGateway.Dashboard.getUri());
    }

    //    @Test
    public void testagain() {
        String text = "GET_https://60sglz9l5h.execute-api.us-east-1.amazonaws.com/dev/chart/Thing-090035-0?startDate=1491567426185";

        String removedTimestamp = text.replaceAll("[0-9]{13}", "*************");
        System.out.println(removedTimestamp);
    }


    String clientEndpoint = "a2awmps9ermju9.iot.us-east-1.amazonaws.com";
    String awsAccessKeyId = "ASIAI33D57VVVW2OZKJA";
    String awsSecretAccessKey = "yBEJXjnrpdEEY7EbVplEUaprUfNsUr1z2MYazt4t";
    String sessionToken = "FQoDYXdzEMD//////////wEaDKXOC2c6D6Yi11wo+SLmA7j50OzH6Vp9lJb0BNKKS07HvBbq7XFL7zyE0x/mlwMizLBKECfyF0SRDHzzSpp/hthJJl9Uz9XwG8fmjri5j0U1GAiftIw+xwmDoLeJax+2cbDDIuZDwTaDrU/DdKQs0/YTVbdIyIGSrHyPWOpdaJLOGStXcYVE0E6MFmgZ+OxaJcoff9/1LxLhkAwGep8rJ1YevYP4AH4enJULGm/UciKxlbf4dCGnX5CqdXODSpNr8YSp18VufI1Ac1nVz3j2ezMtw8jCQm2697nX0Jh5YJaRGbAU7tFQWUYKuU5mSD2ScPYHies2aJJ1BjjrEcgz0jFhahGZm1nwtTLBF2PyjIpcHYqM5C/arRzr6RAp6mfCkLv9RdGsIUUWSgJxk3CzCZGT6E9sRzwwu4xhm8CUt1O9sqlgNLF/0VGnXM5S+6k4fRfTJI2sSQNlKkZ84oNvS4PrcPmlSXw3prm87ke33+M4M9BS0ptPnUlH8zX4L/sq6ARPB3j/6dUbi1KYedF2n0yMVFeMV8OdRx5P+/GnwcVXSNbIzecuefzk32car9c9u/Pnf8jl0zmwuROebWxEun1eqCtJxtDS/yHbC54KhWR4TC5DkEqzqfzp+rmH6L5FiQuDOEqN6f0xTbaifF8jZBsWeJEwsijilL7HBQ==";


    //    @Test
    public void testMQTT() throws AWSIotException, InterruptedException {

        String clientId = "7f2650";

        AWSIotMqttClient awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);
        awsIotClient.setConnectionTimeout(60000);
        awsIotClient.setKeepAliveInterval(60000);
        awsIotClient.connect();


//        String testTopic = "Data/U000001/ODS/Lab/ATMRobot/002/VPV/STA";
        String testTopic = "Heartbeat/l/lk/lk/FGW/Thing-090035";

        AWSIotTopic topic = new TestTopicListener(testTopic, AWSIotQos.QOS0);
        awsIotClient.subscribe(topic, false);


        System.out.println(awsIotClient.getConnectionStatus().toString());
        System.out.println(awsIotClient.getKeepAliveInterval());

        for (int i = 0; i < 10; i++) {
            Thread.sleep(80000);
            awsIotClient.updateCredentials(awsAccessKeyId, awsSecretAccessKey, sessionToken);
            System.out.println("tipa creds updated");
            Thread.sleep(80000);
        }
        awsIotClient.disconnect();
    }

    //    @Test//doesn't work blin
    public void testMQTTSend() throws AWSIotException, InterruptedException {

        String clientId = "lstn";
        String clientId2 = "send";

//        AWSIotMqttClient awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);
//        awsIotClient.setConnectionTimeout(60000);
//        awsIotClient.setKeepAliveInterval(60000);
//        awsIotClient.connect();


        String testTopic = "Data/U000001/ODS/Lab/ATMRobot/002/VPV/STA";
//        String testTopic = "Heartbeat/l/lk/lk/FGW/Thing-090035";

        AWSIotTopic topic = new TestTopicListener(testTopic, AWSIotQos.QOS0);
//        awsIotClient.subscribe(topic);


        AWSIotMqttClient awsIotClient2 = new AWSIotMqttClient(clientEndpoint, clientId2, awsAccessKeyId, awsSecretAccessKey, sessionToken);
//        awsIotClient2.connect();

//        System.out.println(awsIotClient.getConnectionStatus().toString());
//        System.out.println(awsIotClient.getKeepAliveInterval());

        System.out.println(awsIotClient2.getConnectionStatus().toString());
        System.out.println(awsIotClient2.getKeepAliveInterval());

        String payload = "cock";

        awsIotClient2.connect();
        awsIotClient2.publish(testTopic, AWSIotQos.QOS0, payload);

        MyMessage message = new MyMessage(testTopic, AWSIotQos.QOS0, payload);
//        awsIotClient2.connect();
        System.out.println("subscribe");
//        awsIotClient2.subscribe(topic);
        System.out.println("sending");
        awsIotClient2.publish(message, 3000);

//        for (int i = 0; i < 10; i++){
//            Thread.sleep(80000);
//            awsIotClient.updateCredentials(awsAccessKeyId, awsSecretAccessKey,sessionToken);
//            System.out.println("tipa updated");
//            Thread.sleep(80000);
//        }

        System.out.println("oke");
//        awsIotClient.disconnect();
//        awsIotClient2.disconnect();
    }


    //    @Test
    public void createShadow() throws AWSIotException {
        String clientId = "7f2650";
        AWSIotMqttClient awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);

        String thingName = "Thing-000012-i2";                    // replace with your AWS IoT Thing name

        AWSIotDevice device = new AWSIotDevice(thingName);

        awsIotClient.attach(device);
        awsIotClient.connect();

        // Delete existing shadow document
        device.delete();

        // Update shadow document
        String state = "{\"state\":{\"reported\":{\"sensor\":3.0}}}";
        device.update(state);

        // Get the entire shadow document
        String state1 = device.get();
        System.out.println(state1);
    }


    @Test
    public void mqttConnectorTest() {
        String topic = "Data/U000001/ODS/Lab/ATMRobot/002/VPV/STA";
        MQTTConnector mqttConnector = new MQTTConnector();
        mqttConnector.mqttOpen(600000, topic);
//        mqttConnector.mqttOpen(600000);
    }


    public class MyMessage extends AWSIotMessage {
        public MyMessage(String topic, AWSIotQos qos, String payload) {
            super(topic, qos, payload);
        }

        @Override
        public void onSuccess() {
            // called when message publishing succeeded
        }

        @Override
        public void onFailure() {
            // called when message publishing failed
        }

        @Override
        public void onTimeout() {
            // called when message publishing timed out
        }
    }

}
