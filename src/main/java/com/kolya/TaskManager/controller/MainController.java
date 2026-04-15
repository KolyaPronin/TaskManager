package com.kolya.TaskManager.controller;

import com.kolya.TaskManager.dto.TaskDto;
import com.kolya.TaskManager.service.impl.TaskServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "main_endpoints" )
@Slf4j
@RestController
@RequestMapping("/api/task")
public class MainController {
    private final TaskServiceImpl service;
    public MainController(TaskServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Fetching task by id", description = "The request contains the ID" +
            " of the task being received.")
    @GetMapping("/get/{id}")
    public TaskDto getById(@PathVariable Long id){
        return service.getTaskById(id);
    }

    @Operation(summary = "Fetching all existing tasks")
    @GetMapping("/getAll")
    public List<TaskDto> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Create new task", description = "Receives the task DTO and saves it to the database")
    @PostMapping("/create")
    public TaskDto create(@RequestBody TaskDto dto) {
        return service.create(dto);
    }

    @Operation(summary = "delete task by id", description = "Receives the task id and deleting the task from db")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @Operation(summary = "update task", description = "Receives the task id and dto and updating task")
    @PutMapping("/update/{id}")
    public TaskDto update(@PathVariable Long id, @RequestBody TaskDto dto) {
        return service.update(id, dto);
    }
}
