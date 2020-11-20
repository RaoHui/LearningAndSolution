package com.raohui.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class SendController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirect")
    public String sendByDirect(){
        String msg = "send direct.queue Message!!";
        rabbitTemplate.convertAndSend("directExchange","direct.queue",msg);
        return "success Direct";
    }

    @GetMapping("/sendFanout")
    public String sendByFanout(){
        String msg = "send fanout.queue Message!!";
        rabbitTemplate.convertAndSend("fanoutExchange","",msg);
        return "success Fanout";
    }

    @GetMapping("/sendTopic")
    public String sendByTopic(){
        String msg = "send Topic.queue Message!!";
        rabbitTemplate.convertAndSend("topicExchange","topic.A",msg + "topic.A");
        rabbitTemplate.convertAndSend("topicExchange","topic.B",msg + "topic.B");
        rabbitTemplate.convertAndSend("topicExchange","topic.C.D",msg + "topic.C.D");
        return "success Topic";
    }

    @GetMapping("/sendDelay")
    public String sendDelay(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String msg = "send delay queue Message!" + dateFormat.format(new Date());
        rabbitTemplate.convertAndSend("delayExchange","delay.routing",msg);
        return "success delay";
    }
}
