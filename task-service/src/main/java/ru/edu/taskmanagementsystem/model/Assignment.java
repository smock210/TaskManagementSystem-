package ru.edu.taskmanagementsystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Assignment {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private TaskM task;
    @ManyToOne
    private User employee;
    private LocalDate assignedAt;
}
