package system.mqtt;


import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.AWSIotTopic;
import system.constant.URLs;
import system.http.RequestSender;
import system.mqtt.pubSub.TestTopicListener;

import java.util.concurrent.ThreadLocalRandom;

public class MQTTConnector {
    private String clientEndpoint = URLs.MQTTGateway.getValue();

    //THIS ONE IS WORKING
    public void mqttSubscribe(int openConnectionTimeMs, String topic){
        String clientId = ThreadLocalRandom.current().nextInt(9000, 900000 + 1)+"xe";
        String awsAccessKeyId = RequestSender.awsCredentials.getAccessKeyId();
        String awsSecretAccessKey = RequestSender.awsCredentials.getSecretAccessKey();
        String sessionToken = RequestSender.awsCredentials.getSessionToken();

        AWSIotMqttClient awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);
        awsIotClient.setConnectionTimeout(openConnectionTimeMs);
        awsIotClient.setKeepAliveInterval(openConnectionTimeMs);

        try {
            awsIotClient.connect();
        } catch (AWSIotException e) {
            e.printStackTrace();
        }

        AWSIotTopic topicIoT = new TestTopicListener(topic, AWSIotQos.QOS0);

        try {
            awsIotClient.subscribe(topicIoT);
            System.out.println("Subscriber: "+awsIotClient.getConnectionStatus().toString());
        } catch (AWSIotException e) {
            e.printStackTrace();
        }

        sleep(openConnectionTimeMs);

        try {
            awsIotClient.unsubscribe(topic);
            awsIotClient.disconnect();
        } catch (AWSIotException e) {
            e.printStackTrace();
        }
    }

    public void mqttPublish(String topic, String payload){
        String clientId = ThreadLocalRandom.current().nextInt(900, 9000 + 1)+"eP";
        String awsAccessKeyId = RequestSender.awsCredentials.getAccessKeyId();
        String awsSecretAccessKey = RequestSender.awsCredentials.getSecretAccessKey();
        String sessionToken = RequestSender.awsCredentials.getSessionToken();

        AWSIotMqttClient awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);

        try {
            awsIotClient.connect();
            awsIotClient.publish(topic, payload);
            awsIotClient.disconnect();
        } catch (AWSIotException e) {
            e.printStackTrace();
        }
    }


    public void mqttSubscribe(int openConnectionTimeMs){
        String clientId = ThreadLocalRandom.current().nextInt(9000, 900000 + 1)+"xe";
        String awsAccessKeyId = RequestSender.awsCredentials.getAccessKeyId();
        String awsSecretAccessKey = RequestSender.awsCredentials.getSecretAccessKey();
        String sessionToken = RequestSender.awsCredentials.getSessionToken();

        AWSIotMqttClient awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);
        awsIotClient.setConnectionTimeout(openConnectionTimeMs);
        awsIotClient.setKeepAliveInterval(openConnectionTimeMs);

        try {
            awsIotClient.connect();
        } catch (AWSIotException e) {
            e.printStackTrace();
        }

        System.out.println(awsIotClient.getConnectionStatus().toString());

//        if(openConnectionTimeMs > 60000){
//            int runTimeInMinutes = openConnectionTimeMs/60000;
//
//            for (int i = 0; i < runTimeInMinutes; i++){
//                sleep(60000);
//                awsIotClient.updateCredentials(awsAccessKeyId, awsSecretAccessKey,sessionToken);
//            }
//        }

        try {
            awsIotClient.disconnect();
        } catch (AWSIotException e) {
            e.printStackTrace();
        }

    }

    public void mqttSubscribe(int openConnectionTimeMs, String topic, String topic2){
        String clientId = ThreadLocalRandom.current().nextInt(9000, 900000 + 1)+"xe";
        String awsAccessKeyId = RequestSender.awsCredentials.getAccessKeyId();
        String awsSecretAccessKey = RequestSender.awsCredentials.getSecretAccessKey();
        String sessionToken = RequestSender.awsCredentials.getSessionToken();

        AWSIotMqttClient awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);
        awsIotClient.setConnectionTimeout(openConnectionTimeMs);
        awsIotClient.setKeepAliveInterval(openConnectionTimeMs);

        try {
            awsIotClient.connect();
        } catch (AWSIotException e) {
            e.printStackTrace();
        }

        AWSIotTopic topicIoT = new TestTopicListener(topic, AWSIotQos.QOS0);
        AWSIotTopic topicIoT2 = new TestTopicListener(topic2, AWSIotQos.QOS0);

        try {
            awsIotClient.subscribe(topicIoT2, false);
            awsIotClient.subscribe(topicIoT, false);
        } catch (AWSIotException e) {
            e.printStackTrace();
        }


        System.out.println(awsIotClient.getConnectionStatus().toString());
        System.out.println(awsIotClient.getConnectionStatus().toString());

        if(openConnectionTimeMs > 60000){
            int runTimeInMinutes = openConnectionTimeMs/60000;

            for (int i = 0; i < runTimeInMinutes; i++){
                sleep(60000);
                awsIotClient.updateCredentials(awsAccessKeyId, awsSecretAccessKey,sessionToken);
            }
        }

        try {
            awsIotClient.disconnect();
        } catch (AWSIotException e) {
            e.printStackTrace();
        }

    }

    public void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
