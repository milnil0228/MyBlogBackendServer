package com.sparta.myBlogBackendServer.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignupRequestDto {

    @Length(min = 4, max = 10)
    @Pattern(regexp = "^[a-z0-9]*$")
    private String username;

    @Length(min = 8, max = 15)
    @Pattern(regexp = "^[a-zA-Z0-9`~!@#$%^&*()-_=+|\\[\\]{};:'\",.<>/?]*$")
    private String password;
}
