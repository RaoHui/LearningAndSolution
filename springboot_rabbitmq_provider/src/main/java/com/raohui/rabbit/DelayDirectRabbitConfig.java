package com.raohui.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayDirectRabbitConfig {

    //------ 延迟队列 --------
    @Bean
    public Queue delayQueue(){
        Map<String,Object> map = new HashMap<>();

        // x-dead-letter-exchange 声明队列里的死信转发到DLX名称
        map.put("x-dead-letter-exchange","directExchange");
        // x-dead-letter-routing-key 声明死信在转发是所携带的routing_key
        map.put("x-dead-letter-routing-key","direct.queue");
        // x-message-ttl 设置队列中消息的过期时间，单位 毫秒
        map.put("x-message-ttl",5 * 1000);
        return new Queue("delayQueue",true,false,false,map);
    }

    //------ 延迟交换机
    @Bean
    public DirectExchange delayExchange(){
        return new DirectExchange("delayExchange",true,false);
    }

    //------ 把延迟队列和延迟交换机绑定 -----------
    @Bean
    public Binding delayBinding(){
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with("delay.routing");
    }
}
