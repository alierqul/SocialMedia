package com.aliergul.profile.rabbitmq.consumer;



import com.aliergul.auth.rabbitmq.model.MyNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceConsumer {

    @RabbitListener(queues = "queueCreateUser")
    public void consumeNotification(MyNotification notification){
        log.info("Bildirim geldi....: "+ notification.toString());
        log.warn("Bildirim geldi....: "+ notification.toString());
    }


    @RabbitListener(queues = "queueDeleteUser")
    public void consumeDeleteUser(MyNotification notification){
        log.info("Kullanı Silindi....: "+ notification.toString());
    }
}