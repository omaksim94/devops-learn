package com.example.mongodbdemo.service;

import com.example.mongodbdemo.dto.SimpleDto;
import com.example.mongodbdemo.entity.Simple;
import com.example.mongodbdemo.repository.SimpleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SimpleService {
    private final SimpleRepository simpleRepository;
    public SimpleDto create(SimpleDto dto) {
        Simple saved = simpleRepository.save(toEntity(dto));
        return toDto(saved);
    }

    private SimpleDto toDto(Simple entity) {
        return SimpleDto.builder()
                .id(entity.getId())
                .message(entity.getMessage())
                .build();
    }

    private Simple toEntity(SimpleDto dto) {
        return Simple.builder()
                .id(dto.getId())
                .message(dto.getMessage())
                .build();
    }

    public List<SimpleDto> findAll() {
        return simpleRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public SimpleDto findById(String id) {
        return simpleRepository.findById(id)
                .map(this::toDto)
                .orElseGet(() -> new SimpleDto("doesn't exist", "doesn't exist"));
    }
}
