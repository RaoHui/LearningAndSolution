package com.raohui.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    /**
     * 广播交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange",true,false);
    }

    //----  队列 --------
    @Bean
    public Queue queueA(){
        return new Queue("fanoutQueueA",true,false,false,null);
    }

    @Bean
    public Queue queueB(){
        return new Queue("fanoutQueueB",true,false,false,null);
    }

    @Bean
    public Queue queueC(){
        return new Queue("fanoutQueueC",true,false,false,null);
    }

    //------- 绑定 -------

    @Bean
    public Binding bindingFanoutQueueA(){
        return BindingBuilder.bind(queueA()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingFanoutQueueB(){
        return BindingBuilder.bind(queueB()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingFanoutQueueC(){
        return BindingBuilder.bind(queueC()).to(fanoutExchange());
    }
}
