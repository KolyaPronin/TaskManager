package com.kolya.TaskManager.service.impl;

import com.kolya.TaskManager.dto.TaskDto;
import com.kolya.TaskManager.entity.Task;
import com.kolya.TaskManager.exception.TaskNotFoundException;
import com.kolya.TaskManager.repostitory.ITaskRepository;
import com.kolya.TaskManager.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    private final ITaskRepository taskRepository;
    public TaskServiceImpl(ITaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    private TaskDto taskToTaskDto(Task task){
        TaskDto result = new TaskDto();
        result.setId(task.getId());
        result.setTitle(task.getTitle());
        result.setDescription(task.getDescription());
        result.setDone(task.isDone());
        return result;
    }

    public TaskDto getTaskById(Long id){
        log.debug("Fetching task with id={}", id);
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        log.debug("Task fetched: id={}, title={}", task.getId(), task.getTitle());
        return taskToTaskDto(task);
    }

    public List<TaskDto> getAll() {
        log.debug("Fetching all tasks");
        return taskRepository.findAll()
                .stream()
                .map(this::taskToTaskDto)
                .toList();
    }

    public TaskDto create(TaskDto dto) {
        log.debug("Creating a task with title={}", dto.getTitle());
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDone(dto.isDone());
        Task saved = taskRepository.save(task);
        log.debug("Task with title={} was created", saved.getTitle());
        return taskToTaskDto(saved);
    }

    public String delete(Long id) {
        log.debug("Deleting a task with id={}", id);
        taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.deleteById(id);
        log.debug("Task with id={} was deleted", id);
        return "task was deleted";
    }

    public TaskDto update(Long id, TaskDto dto) {
        log.debug("Updating task id={}, title={}", id, dto.getTitle());
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDone(dto.isDone());

        Task saved = taskRepository.save(task);
        log.debug("Task with id={} was updated", id);
        return taskToTaskDto(saved);
    }
}
