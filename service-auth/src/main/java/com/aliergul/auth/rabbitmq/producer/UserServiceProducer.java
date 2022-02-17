package com.aliergul.auth.rabbitmq.producer;



import com.aliergul.auth.rabbitmq.model.MyNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(MyNotification notification) {
        rabbitTemplate.convertAndSend("socialmedia.exchange","routingKeyCreateUSer",notification);
        System.out.println("notification = " + notification.toString());
    }

    public void deleteUser(MyNotification notification) {
        rabbitTemplate.convertAndSend("socialmedia.exchange","routingKeyDeleteUser",notification);
        System.out.println("notification = " + notification.toString());
    }
}