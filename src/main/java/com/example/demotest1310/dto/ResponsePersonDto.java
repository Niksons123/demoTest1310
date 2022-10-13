package com.example.demotest1310.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@Builder
public class ResponsePersonDto {
    String username;
    String email;
}
