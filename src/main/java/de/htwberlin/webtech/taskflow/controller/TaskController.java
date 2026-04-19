package de.htwberlin.webtech.taskflow.controller;

import de.htwberlin.webtech.taskflow.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {

    @GetMapping("/tasks")
    public String getTasks(Model model){
    List<Task> tasks = List.of(
                new Task(1L, "Projekt anlegen", "SpringProjekt erstellen", "Open", "High"),
                new Task(2L, "GetRoute bauen", "Route für TaskListe erstellen", "inProgress", "High"),
                new Task(3L, "Repo pushen", "Code auf GitHub hochladen", "Done", "High")
                );

        model.addAttribute("tasks", tasks);
        return "tasks";

    }
}
