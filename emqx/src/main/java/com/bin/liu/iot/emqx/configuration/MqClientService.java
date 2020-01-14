package com.bin.liu.iot.emqx.configuration;

import com.bin.liu.iot.emqx.config.EmqxConnectConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-14 13:26
 **/

@Configuration
public class MqClientService {


    @Bean
    @ConfigurationProperties(prefix = "emq")
    public EmqxConnectConfig emqxConnectConfig(){
        return new EmqxConnectConfig();
    }

}
