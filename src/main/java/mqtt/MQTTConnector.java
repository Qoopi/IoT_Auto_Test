package mqtt;


import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.AWSIotTopic;
import load.utils.RequestSender;
import mqtt.pubSub.TestTopicListener;

import java.util.concurrent.ThreadLocalRandom;

public class MQTTConnector {
    private String clientEndpoint = "a2awmps9ermju9.iot.us-east-1.amazonaws.com";

    public void mqttOpen(int openConnectionTimeMs, String topic){
        String clientId = ThreadLocalRandom.current().nextInt(9000, 900000 + 1)+"xe";
        String awsAccessKeyId = RequestSender.awsCredentials.getAccessKeyId();
        String awsSecretAccessKey = RequestSender.awsCredentials.getSecretAccessKey();
        String sessionToken = RequestSender.awsCredentials.getSessionToken();

        AWSIotMqttClient awsIotClient = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);
        awsIotClient.setConnectionTimeout(openConnectionTimeMs);

        try {
            awsIotClient.connect();
        } catch (AWSIotException e) {
            e.printStackTrace();
        }

        AWSIotTopic topicIoT = new TestTopicListener(topic, AWSIotQos.QOS0);

        try {
            awsIotClient.subscribe(topicIoT, false);
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
                System.out.println("credentials checked");
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
                System.out.println("credentials checked");
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
