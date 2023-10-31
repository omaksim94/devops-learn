package com.example.mongodbdemo.repository;

import com.example.mongodbdemo.entity.Simple;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleRepository extends MongoRepository<Simple, String> {
}
