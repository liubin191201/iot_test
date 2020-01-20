package com.bin.liu.iot.emqx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: iot-test
 * @description:
 * @author: bin.liu
 * @create: 2020-01-17 16:26
 **/

public class AsynCallBackTest {

    public static void main(String[] args) {
        System.out.println("[main is start]");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CallBack callBack = new CallBack();
        for (int i = 0; i < 100000; i++) {
            Task task = new Task(callBack, "content:" + i);
            executorService.submit(task);
        }

        System.out.println("[main is end]");
        executorService.shutdown();

    }


    static class CallBack{
        public void success(Object result){
            System.out.println("callback success message" + result);
        }

        public CallBack() {
        }
    }


    static class Task implements Runnable{

        private  CallBack callBack;

        private String content;

        @Override
        public void run() {
            System.out.println("do things" + content);
            callBack.success(content);
        }

        public Task(CallBack callBack, String content) {
            this.callBack = callBack;
            this.content = content;
        }
    }
}
