package com.bin.liu.iot.emqx;

import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-16 17:15
 **/
@Log4j2
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public abstract class AbstractTest {
}
