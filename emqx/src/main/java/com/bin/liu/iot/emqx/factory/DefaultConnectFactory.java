package com.bin.liu.iot.emqx.factory;

import com.bin.liu.iot.emqx.client.DefaultConnectClient;
import com.bin.liu.iot.emqx.config.EmqxConnectConfig;
import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.MqttClient;

/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-14 11:35
 **/
@Log4j2
public class DefaultConnectFactory{

    public static MqttClient connect(EmqxConnectConfig connectConfig){

        DefaultConnectClient connectClient = new DefaultConnectClient();
        MqttClient mqttClient = null;
        try {
            mqttClient = connectClient.NEW_INSTANCE(connectConfig);
            connectClient.connect(mqttClient, connectConfig);
        } catch (Exception e) {
            log.error("[connect mqttClient error]",e);
        }
        return mqttClient;
    }
}
