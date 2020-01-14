package com.bin.liu.iot.emqx.config;

import lombok.Data;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @program: iot-test
 * @description: emqx获取连接配置
 * @author: bin.liu
 * @create: 2020-01-14 10:45
 **/
@Data
public class EmqxConnectConfig {

    /**
     * broker地址
     */
    private String broker;

    /**
     *
     * 客户端id必须唯一
     */
    private String clientId;

    /**
     *
     * 持久化类型，默认：内存存储
     */
    private MqttClientPersistence persistence = new MemoryPersistence();


    //连接选项

    /**
     *
     * 是否清除会话
     */
    private Boolean isCleanSession = Boolean.TRUE;








}
