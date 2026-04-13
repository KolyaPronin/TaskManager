package com.kolya.TaskManager.service;

import com.kolya.TaskManager.dto.TaskDto;

public interface TaskService {
    public TaskDto create(TaskDto dto); // title, description, state
}
