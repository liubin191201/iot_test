package com.bin.liu.iot.emqx.publish;

import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-14 15:48
 **/
@Log4j2
@Service
public class PublishService {

    public void publish(MqttClient mqttClient,String topic, String content,Integer qos) throws Exception{
        log.info("[publish message start,topic:{},content:{},qos:{}]",topic,content,qos);
        MqttMessage message = new MqttMessage();
        message.setPayload(content.getBytes());
        message.setQos(qos);
        message.setRetained(true);
        mqttClient.publish(topic, message);
        log.info("[publish message end,topic:{},content:{},qos:{}]",topic,content,qos);
    }
}
