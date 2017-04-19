package mqtt;


import com.amazonaws.services.iot.client.*;
import load.URLs;
import load.utils.RequestSender;
import mqtt.pubSub.TestTopicListener;

import java.util.concurrent.ThreadLocalRandom;

public class MQTTConnector {
    private String clientEndpoint = URLs.MQTTGateway.getValue();

    public void mqttOpen(int openConnectionTimeMs, String topic){
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
            awsIotClient.subscribe(topicIoT, false);
            System.out.println("Subscribed");
        } catch (AWSIotException e) {
            e.printStackTrace();
        }


        System.out.println(awsIotClient.getConnectionStatus().toString());
        System.out.println(awsIotClient.getKeepAliveInterval());

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

    public void mqttOpen(int openConnectionTimeMs, String topic, String topic2){
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


    public void mqttOpen(int openConnectionTimeMs){
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
        System.out.println(awsIotClient.getKeepAliveInterval());

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

    private void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
