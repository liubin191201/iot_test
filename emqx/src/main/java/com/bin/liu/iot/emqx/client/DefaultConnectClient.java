package com.bin.liu.iot.emqx.client;

import com.bin.liu.iot.emqx.config.EmqxConnectConfig;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;


/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-14 11:00
 **/
@AllArgsConstructor
public class DefaultConnectClient implements ConnectClient {

    private static Logger logger = LoggerFactory.getLogger(DefaultConnectClient.class);


    public MqttClient NEW_INSTANCE(EmqxConnectConfig emqxConnectConfig) throws Exception{

        String broker = emqxConnectConfig.getBroker();
        Assert.notNull(broker, "[broker is not null]");
        String clientId = emqxConnectConfig.getClientId();
        Assert.notNull(clientId, "[clientId is not null]");
        MqttClientPersistence persistence = emqxConnectConfig.getPersistence();
        if (null == persistence){
            persistence = new MemoryPersistence();
        }

        if (logger.isDebugEnabled()){
            logger.info("[ start init mqttClient ......]");
        }
        MqttClient mqttClient = new MqttClient(broker,clientId,persistence);

        if (logger.isDebugEnabled()){
            logger.info("[ finish mqttClient ......]");
        }

        return mqttClient;
    }

    public void connect(MqttClient mqttClient, EmqxConnectConfig connectConfig) throws Exception {
        Assert.notNull(mqttClient, "[ mqttClient is not init ]");
        if (logger.isDebugEnabled()){
            logger.info("[mqttClient start connect ......]");
        }
        Boolean isCleanSession = connectConfig.getIsCleanSession();
        if (null == isCleanSession){
            isCleanSession = Boolean.TRUE;
        }

        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(isCleanSession);

        mqttClient.connect(options);
        if (logger.isDebugEnabled()){
            logger.info("[mqttClient finish connect ......]");
        }

    }

}
