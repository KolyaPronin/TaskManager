package com.kolya.TaskManager.controller;

import com.kolya.TaskManager.dto.TaskDto;
import com.kolya.TaskManager.service.impl.TaskServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class MainController {
    private final TaskServiceImpl service;
    public MainController(TaskServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/api/task/get/{id}")
    public TaskDto getById(@PathVariable Long id){
        return service.getTaskById(id);
    }

    @GetMapping("/api/task/getAll")
    public List<TaskDto> getAll() {
        return service.getAll();
    }

    @PostMapping("/api/task/create")
    public TaskDto create(@RequestBody TaskDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/api/task/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PostMapping("/api/task/update")
    public TaskDto update(@RequestBody TaskDto dto) {
        return service.update(dto);
    }
}
