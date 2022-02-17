package com.aliergul.socialmedia.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document
public class Interest {
    @Id
    String id;
    String name;
    List<String> userList;

}
