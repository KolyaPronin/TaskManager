package com.kolya.TaskManager.service.impl;

import com.kolya.TaskManager.dto.TaskDto;
import com.kolya.TaskManager.entity.Task;
import com.kolya.TaskManager.repostitory.ITaskRepository;
import com.kolya.TaskManager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Task task = taskRepository.getReferenceById(id);
        return taskToTaskDto(task);
    }

    public List<TaskDto> getAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> {
                    TaskDto dto = new TaskDto();
                    dto.setId(task.getId());
                    dto.setTitle(task.getTitle());
                    dto.setDescription(task.getDescription());
                    dto.setDone(task.isDone());
                    return dto;
                })
                .toList();
    }


    public TaskDto create(TaskDto dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDone(dto.isDone());

        Task saved = taskRepository.save(task);
        TaskDto result = new TaskDto();
        result.setId(saved.getId());
        result.setTitle(saved.getTitle());
        result.setDescription(saved.getDescription());
        result.setDone(saved.isDone());
        return result;
    }

    public String delete(Long id) {
        taskRepository.deleteById(id);
        return "task was deleted";
    }

    public TaskDto update(Long id, TaskDto dto) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDone(dto.isDone());

        Task saved = taskRepository.save(task);

        TaskDto result = new TaskDto();
        result.setId(saved.getId());
        result.setTitle(saved.getTitle());
        result.setDescription(saved.getDescription());
        result.setDone(saved.isDone());

        return result;
    }
}
