package com.newoxen.springcloud.tbms.kafakalog.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Kafka日志监听演示
 * gaowei
 */

@Component
public class ConsumerListener {

    @KafkaListener(topics = "test")
    public void onMessage(String message){
        //insertIntoDb(buffer);//这里为插入数据库代码
        System.out.println(message);
    }

}