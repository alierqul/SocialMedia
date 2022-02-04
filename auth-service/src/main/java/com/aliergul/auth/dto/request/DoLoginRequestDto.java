package com.aliergul.auth.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoLoginRequestDto {
    @Email
    @NotNull
    String username;
    @NotNull
    @Size(min=8,max=32)
    String password;


}
