package com.raohui.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    /**
     * 交换机
     * @return
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange",true,false);
    }

    //------- 队列 -------

    @Bean
    public Queue topicQueueA(){
        return new Queue("topicQueueA",true,false,false,null);
    }

    @Bean
    public Queue topicQueueB(){
        return new Queue("topicQueueB",true,false,false,null);
    }

    //------ 绑定 ------

    @Bean
    public Binding bindingTopicQueueA(){
        //routingKey *:匹配一个单词
        return BindingBuilder.bind(topicQueueA()).to(topicExchange()).with("topic.*");
    }

    @Bean
    public Binding bindingTopicQueueB(){
        //routingKey #:匹配0个或多个单词
        return BindingBuilder.bind(topicQueueB()).to(topicExchange()).with("topic.#");
    }
}
