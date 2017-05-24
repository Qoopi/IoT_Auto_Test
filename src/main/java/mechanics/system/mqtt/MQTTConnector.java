package mechanics.system.mqtt;


import com.amazonaws.services.iot.client.*;
import mechanics.system.constant.AssembledUrls;
import mechanics.system.http.RequestSender;
import mechanics.system.mqtt.pubSub.TestTopicListener;

import java.util.concurrent.ThreadLocalRandom;

public class MQTTConnector {
    private String clientEndpoint = AssembledUrls.iotEndpoint;
    private final int connectionRetries = 2;

    public void mqttSubscribe(int openConnectionTimeMs, String topic){
        String clientId = ThreadLocalRandom.current().nextInt(10, 999999 + 1)+"ex";
        String awsAccessKeyId = RequestSender.awsCredentials.getAccessKeyId();
        String awsSecretAccessKey = RequestSender.awsCredentials.getSecretAccessKey();
        String sessionToken = RequestSender.awsCredentials.getSessionToken();

        AWSIotMqttClient awsIotClient;
        if (sessionToken==null || sessionToken.equals("") || sessionToken.isEmpty()){
            System.out.println("Launching IoT client without session token.");
            System.out.println("=========================");
            awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey);
        }
        else{
            System.out.println("Launching IoT client using session token.");
            System.out.println("=========================");
            awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);
        }


        awsIotClient.setConnectionTimeout(openConnectionTimeMs);
        awsIotClient.setKeepAliveInterval(openConnectionTimeMs);
        awsIotClient.setMaxConnectionRetries(connectionRetries);

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

        if (awsIotClient.getConnectionStatus().equals(AWSIotConnectionStatus.CONNECTED)){
            sleep(openConnectionTimeMs);
            try {
                awsIotClient.unsubscribe(topic);
                awsIotClient.disconnect();
            } catch (AWSIotException e) {
                e.printStackTrace();
            }
        }
    }

    public void mqttPublish(String topic, String payload){
        String clientId = ThreadLocalRandom.current().nextInt(10, 999999 + 1)+"eP";
        String awsAccessKeyId = RequestSender.awsCredentials.getAccessKeyId();
        String awsSecretAccessKey = RequestSender.awsCredentials.getSecretAccessKey();
        String sessionToken = RequestSender.awsCredentials.getSessionToken();

        AWSIotMqttClient awsIotClient;
        if (sessionToken==null || sessionToken.equals("") || sessionToken.isEmpty()){
            System.out.println("Launching IoT client without session token.");
            System.out.println("=========================");
            awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey);
        }
        else{
            System.out.println("Launching IoT client using session token.");
            System.out.println("=========================");
            awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);
        }

        awsIotClient.setMaxConnectionRetries(connectionRetries);

        try {
            if(awsIotClient.getConnectionStatus().equals(AWSIotConnectionStatus.DISCONNECTED)){
                awsIotClient.connect();
            }
            awsIotClient.publish(topic, payload);
            if (awsIotClient.getConnectionStatus().equals(AWSIotConnectionStatus.CONNECTED)){
                awsIotClient.disconnect();
            }
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
