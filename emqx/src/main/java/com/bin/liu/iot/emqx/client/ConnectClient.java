package com.bin.liu.iot.emqx.client;

import com.bin.liu.iot.emqx.config.EmqxConnectConfig;
import org.eclipse.paho.client.mqttv3.MqttClient;

/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-14 10:56
 **/

interface ConnectClient {

    MqttClient NEW_INSTANCE(EmqxConnectConfig emqxConnectConfig) throws Exception;

    void connect(MqttClient mqttClient, EmqxConnectConfig connectConfig) throws Exception;

}
