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
public class DirectRabbitConfig {

    /**
     * 交换机
     * @return
     */
    @Bean
    public DirectExchange myDirectExchange(){
        //参数意义：
        //name:名称
        //durable:是否持久化
        //autoDelete:是否自动删除
        return new DirectExchange("directExchange",true,false);
    }

    /**
     * 队列
     * @return
     */
    @Bean
    public Queue myDirectQueue(){
        //参数意义：
        //name:名称
        //durable:是否持久化
        //exclusive:是否独占连接
        //autoDelete:是否自动删除
        //arguments:附加参数
        return new Queue("directQueue",true,false,false,null);
    }

    /**
     * 绑定
     * @return
     */
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(myDirectQueue()).to(myDirectExchange()).with("direct.queue");
    }

}
