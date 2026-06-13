package de.htwberlin.webtech.taskflow.service;

import de.htwberlin.webtech.taskflow.entity.Task;
import de.htwberlin.webtech.taskflow.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository repo;

    public Task save(Task task) {
        return repo.save(task);
    }

    public Task get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

}
