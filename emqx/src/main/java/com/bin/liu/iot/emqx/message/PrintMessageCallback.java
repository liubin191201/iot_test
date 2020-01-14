package com.bin.liu.iot.emqx.message;

import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.text.MessageFormat;

/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-14 15:40
 **/
@Log4j2
public class PrintMessageCallback implements MessageCallback{

    public void connectionLost(Throwable throwable) {
        log.info("[server is lost]");

    }

    public void messageArrived(String topcic, MqttMessage message) throws Exception {
        String mStr = MessageFormat.format("[{0} is arrived for topic:{1},messageId:{2}]", new String(message.getPayload()), topcic,message.getId());
        log.info(mStr);
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info("[message has been completed]");
    }
}
