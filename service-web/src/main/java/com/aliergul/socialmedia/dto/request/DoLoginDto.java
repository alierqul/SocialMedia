package com.aliergul.socialmedia.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DoLoginDto {
    @NotNull
    @Email
    String username;
    @NotNull
    @Size(min = 8,max = 32)
    String password;
}
