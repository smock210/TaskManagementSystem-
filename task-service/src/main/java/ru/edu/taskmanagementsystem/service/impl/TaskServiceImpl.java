package ru.edu.taskmanagementsystem.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.taskmanagementsystem.aop.annotations.Audited;
import ru.edu.taskmanagementsystem.model.Status;
import ru.edu.taskmanagementsystem.model.TaskM;
import ru.edu.taskmanagementsystem.repository.TaskRepository;
import ru.edu.taskmanagementsystem.service.TaskService;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Audited
    @Transactional
    public TaskM createTask(String title, String description, String status) {
        TaskM task = new TaskM();
        task.setTitle(title);
        task.setStatus(Status.valueOf(status));
        task.setDescription(description);
        //task.setDateOfCreate(LocalDateTime.parse(date));
        return taskRepository.save(task);
    }

    @Override
    public TaskM createTask(TaskM task) {
        return taskRepository.save(task);
    }



    @Override
    public TaskM findById(Long id) {
        return taskRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Iterable<TaskM> findAll() {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }



    @PostConstruct
    public void fillDatabase() {
        TaskM task = new TaskM();
        task.setTitle("task description 1");
        taskRepository.save(task);
    }
}
