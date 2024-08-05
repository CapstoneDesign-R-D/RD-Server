package com.dgucd.dguspring.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class RegisterRequestDTO {
    private String userEmail;
    private String userName;
}
