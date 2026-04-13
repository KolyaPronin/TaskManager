package com.kolya.TaskManager.dto;
//DataTransferObject
import lombok.Data;
@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private boolean done;
}
