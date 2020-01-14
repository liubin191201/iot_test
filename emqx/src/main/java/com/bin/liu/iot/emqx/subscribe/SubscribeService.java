package com.bin.liu.iot.emqx.subscribe;

import com.bin.liu.iot.emqx.config.EmqxConnectConfig;
import com.bin.liu.iot.emqx.message.MessageCallback;
import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-14 13:23
 **/
@Log4j2
@Service
public class SubscribeService {

    @Autowired
    private EmqxConnectConfig connectConfig;


    public void subscribe(MqttClient mqttClient,String topic, Integer qos, MessageCallback messageCallback) throws Exception{
        log.info("[subscribe start,topic:{},qos:{}]",topic,qos);
        mqttClient.subscribe(topic, qos);
        mqttClient.setCallback(messageCallback);
        log.info("[subscribe end,topic:{},qos:{}]",topic,qos);
    }


}
