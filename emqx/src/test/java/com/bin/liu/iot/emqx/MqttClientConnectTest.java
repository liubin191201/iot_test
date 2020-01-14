package com.bin.liu.iot.emqx;

import com.bin.liu.iot.emqx.config.EmqxConnectConfig;
import com.bin.liu.iot.emqx.enums.QosEnum;
import com.bin.liu.iot.emqx.factory.DefaultConnectFactory;
import com.bin.liu.iot.emqx.message.PrintMessageCallback;
import com.bin.liu.iot.emqx.publish.PublishService;
import com.bin.liu.iot.emqx.subscribe.SubscribeService;
import lombok.extern.log4j.Log4j2;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-14 11:42
 **/
@Log4j2
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MqttClientConnectTest {

    @Autowired
    private EmqxConnectConfig connectConfig;

    @Autowired
    private SubscribeService subscribeService;

    @Autowired
    private PublishService publishService;

    private String topic = "demo/topics";


    @Test
    public void testConnect() throws Exception {
        EmqxConnectConfig connectConfig = new EmqxConnectConfig();
        connectConfig.setBroker("tcp://localhost:1883");
        connectConfig.setClientId("client-01");
        connectConfig.setPersistence(new MemoryPersistence());
        MqttClient mqttClient = DefaultConnectFactory.connect(connectConfig);


    }

    @Test
    public void publishMessage() {
        try {
            MqttClient connect = DefaultConnectFactory.connect(connectConfig);
            subscribeService.subscribe(connect, topic, QosEnum.QOS1.getLevel(), new PrintMessageCallback());

            for (int i = 0; i < 1000; i++) {
                publishService.publish(connect, topic, "test_content_" + i, QosEnum.QOS1.getLevel());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
