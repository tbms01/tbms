package com.newoxen.springcloud.tbms.kafakalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kafka日志收集演示
 * gaowei
 */

@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/kafka/send")
    public boolean send(@RequestParam String message){
        kafkaTemplate.send("test",message);
        return true;
    }

}
