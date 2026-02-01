package ru.edu.taskmanagementsystem.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class TaskDtoRequest {

    @NonNull
    private String id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private String status;
    @NonNull
    private String dateTime;
}
