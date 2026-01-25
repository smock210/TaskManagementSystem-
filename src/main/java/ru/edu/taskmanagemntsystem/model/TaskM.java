package ru.edu.taskmanagemntsystem.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskM {
    private long id;
    private String title;
    private String textOfTask;
    private Status status;
    private LocalDateTime dateOfCreate;
    private LocalDateTime dateOfLastChange;
    private LocalDateTime dateOfClose;
    private List<Comment> comment;
}
