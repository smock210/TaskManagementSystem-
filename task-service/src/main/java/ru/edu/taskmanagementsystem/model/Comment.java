package ru.edu.taskmanagementsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table (name = "coments_table")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private LocalDateTime date;
}
