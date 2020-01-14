package com.bin.liu.iot.emqx.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-14 15:34
 **/
@Getter
@AllArgsConstructor
public enum QosEnum {
    //最多一次
    QOS0(0, "最多一次"),
    //最少一次
    QOS1(1, "最少一次"),
    //只有一次
    QOS2(2, "只有一次"),
    ;

    private Integer level;

    private String desc;

}
