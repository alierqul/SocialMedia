package com.aliergul.web.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class DoLoginResponseDto {
    String id;
    int status;
    int error;
}
