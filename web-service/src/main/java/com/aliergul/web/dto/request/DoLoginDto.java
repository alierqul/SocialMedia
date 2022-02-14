package com.aliergul.web.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoLoginDto {
    @NotNull
    @Email
    String email;
    @NotNull
    @Size(min = 8,max = 32)
    String password;
}
