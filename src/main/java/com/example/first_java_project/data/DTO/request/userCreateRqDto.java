package com.example.first_java_project.data.request.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class userCreateRqDto {
    private Long userId;
    private String password;
    private LocalDateTime registrationDate;
    private String userName;
    private String email;
}
