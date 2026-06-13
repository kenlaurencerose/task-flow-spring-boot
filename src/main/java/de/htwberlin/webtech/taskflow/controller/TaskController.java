package de.htwberlin.webtech.taskflow.controller;

import de.htwberlin.webtech.taskflow.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TaskController {

    @GetMapping("/")
    public List<Task> getTasks(Model model){
    List<Task> tasks = List.of(
                new Task(1L, "Projekt anlegen", "SpringProjekt erstellen", "Open", "High"),
                new Task(2L, "GetRoute bauen", "Route für TaskListe erstellen", "inProgress", "High"),
                new Task(3L, "Repo pushen", "Code auf GitHub hochladen", "Done", "High")
                );

        return tasks;

    }
}
//.