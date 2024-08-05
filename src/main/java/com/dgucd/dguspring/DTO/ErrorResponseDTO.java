package com.dgucd.dguspring.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ErrorResponseDTO {
    private Date timestamp;
    private int status;
    private String error;
    private String path;
}
