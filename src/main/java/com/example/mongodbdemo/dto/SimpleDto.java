package com.example.mongodbdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SimpleDto {
    private String id;
    private String message;
}
