package com.kolya.TaskManager.controller;

import com.kolya.TaskManager.dto.TaskDto;
import com.kolya.TaskManager.service.impl.TaskServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/task")
public class MainController {
    private final TaskServiceImpl service;
    public MainController(TaskServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    public TaskDto getById(@PathVariable Long id){
        return service.getTaskById(id);
    }

    @GetMapping("/getAll")
    public List<TaskDto> getAll() {
        return service.getAll();
    }

    @PostMapping("/create")
    public TaskDto create(@RequestBody TaskDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/update/{id}")
    public TaskDto update(@PathVariable Long id, @RequestBody TaskDto dto) {
        return service.update(id, dto);
    }
}
