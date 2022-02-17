package com.aliergul.socialmedia.rabbitmq.consumer;


import com.aliergul.socialmedia.mapper.ProfileMapper;
import com.aliergul.socialmedia.rabbitmq.model.ProfileNotification;
import com.aliergul.socialmedia.repository.IProfileReposity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileConsumer {

    private final IProfileReposity reposity;
    private final ProfileMapper profileMapper;

    @RabbitListener(queues = "profile-save-queue")
    public void handleProfileSave(ProfileNotification notification) {
        reposity.save(profileMapper.toProfile(notification));
        log.info("Profile saved: {}", notification.toString());
    }

}