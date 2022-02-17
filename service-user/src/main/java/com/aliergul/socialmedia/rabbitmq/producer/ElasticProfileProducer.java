package com.aliergul.socialmedia.rabbitmq.producer;


import com.aliergul.socialmedia.rabbitmq.model.ProfileNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElasticProfileProducer {

    private final RabbitTemplate   rabbitTemplate;

    public void sendMessageProfileSave(ProfileNotification notification) {
        rabbitTemplate.convertAndSend("socialmedia.exchange","elastic-key-profile-save",notification);

    }
}
