package com.example.mongodbdemo.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("simple")
@Data
@Builder
public class Simple {
    @Id
    private String id;
    private String message;
}
