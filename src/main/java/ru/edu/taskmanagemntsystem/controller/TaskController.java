package ru.edu.taskmanagemntsystem.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.taskmanagemntsystem.dto.TaskDtoResponce;
import ru.edu.taskmanagemntsystem.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    /*private final TaskMapper taskMapper;

    @GetMapping("/getAllEvents")
    public ResponseEntity<@NonNull List<TaskDtoResponce>> getAllEvents() {
        return ResponseEntity.ok(taskMapper.toDto(taskService.findAll()));
    }

    @GetMapping("/getEventById/{id}")
    public ResponseEntity<@NonNull TaskDtoResponse> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(taskMapper.toDto(taskService.findById(id)));
    }

    @DeleteMapping("/deleteEventById/{id}")
    public void deleteEventById(@PathVariable Long id) {
        taskService.deleteById(id);
    }

    @DeleteMapping("/deleteAllEvents")
    public void deleteAllEvents() {
        taskService.deleteAll();
    }

    @PostMapping("/createEvent")
    public ResponseEntity<@NonNull TaskDtoResponse> createEvent(@RequestBody TaskDtoRequest request) {
        return ResponseEntity.ok(taskMapper
                .toDto(taskService.createEvent(request.getTitle(), LocalDateTime.now().toString())));
    }

    @GetMapping("/existsById/{id}")
    public ResponseEntity<@NonNull Boolean> existsById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.existsById(id));
    }*/
}