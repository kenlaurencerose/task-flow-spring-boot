package de.htwberlin.webtech.taskflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titel darf nicht leer sein")
    @Size(max = 255, message = "Titel darf maximal 255 Zeichen lang sein")
    private String title;

    @Size(max = 2000, message = "Beschreibung darf maximal 2000 Zeichen lang sein")
    private String description;

    @NotBlank(message = "Status darf nicht leer sein")
    @Pattern(regexp = "Offen|Erledigt", message = "Status muss 'Offen' oder 'Erledigt' sein")
    private String status;

    @NotBlank(message = "Priorität darf nicht leer sein")
    @Pattern(regexp = "Niedrig|Normal|Hoch", message = "Priorität muss 'Niedrig', 'Normal' oder 'Hoch' sein")
    private String priority;

    public Task() {}

    public Task(String title, String description, String status, String priority) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}