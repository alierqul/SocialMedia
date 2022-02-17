package com.aliergul.auth.rabbitmq.model;

import lombok.*;


import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MyNotification implements Serializable {
    private static final long serialVersionUID=1L;
    private String message;
    private String sender;
    private String receiver;
    private long createAt;
    private String notificationId;

}
