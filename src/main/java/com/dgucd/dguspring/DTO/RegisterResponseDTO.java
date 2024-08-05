package com.dgucd.dguspring.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class RegisterResponseDTO {
    private String userName;
    private String message;
}
