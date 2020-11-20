package com.raohui.springbootrabbitmq.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DirectReceiver {

    @RabbitListener(queues = "directQueue")
    @RabbitHandler
    public void directProcess(String msg, Channel channel, Message message) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println("消费directQueue========" + msg);
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                channel.basicReject(deliveryTag, false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "fanoutQueueA")
    public void fanoutProcessA(String msg, Channel channel, Message message) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println("消费fanoutQueueA======" + msg);
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                channel.basicReject(deliveryTag, false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "fanoutQueueB")
    @RabbitHandler
    public void fanoutProcessB(String msg, Channel channel, Message message) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println("消费fanoutQueueB======" + msg);
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                channel.basicReject(deliveryTag, false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = "fanoutQueueC")
    @RabbitHandler
    public void fanoutProcessC(String msg, Channel channel, Message message) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println("消费fanoutQueueC======" + msg);
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                channel.basicReject(deliveryTag, false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    @RabbitListener(queues = "topicQueueA")
    @RabbitHandler
    public void topicProcessA(String msg, Channel channel, Message message) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println("消费topicQueueA======" + msg);
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                channel.basicReject(deliveryTag, false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    @RabbitListener(queues = "topicQueueB")
    @RabbitHandler
    public void topicProcessB(String msg, Channel channel, Message message) {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            System.out.println("消费topicQueueB======" + msg);
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            try {
                channel.basicReject(deliveryTag, false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}
