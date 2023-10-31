package com.example.mongodbdemo.rest;

import com.example.mongodbdemo.dto.SimpleDto;
import com.example.mongodbdemo.service.SimpleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simple")
@RequiredArgsConstructor
public class SimpleController {
    private final SimpleService simpleService;

    @PostMapping
    public SimpleDto create(@RequestBody SimpleDto dto) {
        return simpleService.create(dto);
    }

    @GetMapping
    public List<SimpleDto> findAll() {
        return simpleService.findAll();
    }

    @GetMapping("/{id}")
    public SimpleDto findById(@PathVariable("id") String id) {
        return simpleService.findById(id);
    }
}
