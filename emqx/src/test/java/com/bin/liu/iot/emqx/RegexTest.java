package com.bin.liu.iot.emqx;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-16 17:15
 **/
public class RegexTest extends AbstractTest{

    private static String heartPackage = "ACT:heartbeat;RSSI:0~99;ORDERLIST:MCS-20190111-161536-45228|8C2C090135|2,MCS-20190111-161536-45228|8C2C090135|2;SLOTSTATUS:0F-0F-0F-0F-0F-0F-0F-0F-0F-0F-;USABLE_BATTERY:4;EMPTY_SLOT_COUNT:0;TOTAL:10;USABLE_BATTERY_NEW:1_0#2_0#3_0#4_4;TIMESTAMP:1547194516;STATIONID:805896;STATUS:0;CH:S1,08,3689mV,0mA,33,0,00FF0000|S2,08,3719mV,0mA,43,0,00FF0000|S3,08,3755mV,0mA,53,0,00FF0000|S4,0F,3858mV,2235mA,513,393,00FF0000|S5,0F,3906mV,2235mA,523,403,00FF0000|S6,0F,3893mV,2235mA,533,413,00FF0000|S7,08,3445mV,0mA,0,0,00FF0000|S8,08,3417mV,0mA,0,0,00FF0000|S9,08,3458mV,0mA,0,0,00FF0000|S10,08,3285mV,0mA,0,0,00FF0000|;CHKSUM:A0E945D5";

    @Test
    public void  testHeartPackage(){
        Pattern pattern = Pattern.compile("ORDERLIST:(.*);SLOTSTATUS");
        Matcher matcher = pattern.matcher(heartPackage);
        if (matcher.find()){
            String group = matcher.group(1);
            if (!StringUtils.isEmpty(group)){
                String[] split = group.split(",");
                List<String> list = Arrays.asList(split);

                list.forEach(new MyAction());
            }
        }


    }


    class MyAction implements Consumer<String>{
        public void accept(String s) {
            System.out.println("s = " + s);
        }
    }
}
