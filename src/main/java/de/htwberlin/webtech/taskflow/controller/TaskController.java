package de.htwberlin.webtech.taskflow.controller;

import de.htwberlin.webtech.taskflow.entity.Task;
import de.htwberlin.webtech.taskflow.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping("/tasks")
    public Task createTask (@RequestBody Task task){
        return service.save(task);
    }

    @GetMapping("/")
    public List<Task> getAllTasks() {
        return service.getAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTasks(@PathVariable String id){
    Long taskId = Long.parseLong(id);
        return service.get(taskId);

    }
}
