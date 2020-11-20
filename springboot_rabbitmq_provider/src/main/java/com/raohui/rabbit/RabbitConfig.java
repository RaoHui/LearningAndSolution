package com.raohui.rabbit;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* 生产者回调确认
**/
@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);

        //开启Mandatory才能触发回调函数，无论消息推送是否成功都会强制调用回调函数
        rabbitTemplate.setMandatory(true);

        //-----消息推送四种情况----------
        //1:消息推送没有找到交换机 触发ConfirmCallback函数
        //2:消息推送找到交换机但是没有找到队列,触发ConfirmCallback，ReturnCallBack两个函数
        //3:消息推送没有找到交换机和队列,触发ConfirmCallback函数
        //4.消息推送成功，触发ConfirmCallback函数
        //-----------------------------------

        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String s) {
                System.out.println("correlationData-相关数据:" + correlationData);
                System.out.println("ack-确认情况" + ack);
                System.out.println("s-原因:" + s);
            }
        });

        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("ReturnsCallback--消息: " + returnedMessage.getMessage());
                System.out.println("ReturnsCallback--回应码: " + returnedMessage.getReplyCode());
                System.out.println("ReturnsCallback--回应信息: " + returnedMessage.getReplyText());
                System.out.println("ReturnsCallback--交换机: " + returnedMessage.getExchange());
                System.out.println("ReturnsCallback--路由键: " + returnedMessage.getRoutingKey());
            }
        });

        return rabbitTemplate;
    }
}
