package ru.edu.taskmanagemntsystem.dto;

import lombok.Data;
import lombok.NonNull;

//@Data
public class TaskDtoResponce  extends TaskDto{

    public TaskDtoResponce(@NonNull String id, @NonNull String value, @NonNull String dateTime) {
        super(id, value, dateTime);
    }
}
