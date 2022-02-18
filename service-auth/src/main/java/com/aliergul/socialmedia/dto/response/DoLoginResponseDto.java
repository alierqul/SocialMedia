package com.aliergul.socialmedia.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class DoLoginResponseDto {
    String id;
    String token;
    int status;
    int error;
}
