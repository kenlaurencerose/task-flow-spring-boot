package de.htwberlin.webtech.taskflow.service;

import de.htwberlin.webtech.taskflow.entity.Task;
import de.htwberlin.webtech.taskflow.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository repo;

    @InjectMocks
    private TaskService service;

    private Task task;

    @BeforeEach
    void setUp() {
        task = new Task("Titel", "Beschreibung", "OPEN", "HIGH");
        task.setId(1L);
    }

    @Test
    void save_shouldReturnSavedTask() {
        when(repo.save(task)).thenReturn(task);

        Task result = service.save(task);

        assertEquals(task, result);
        verify(repo, times(1)).save(task);
    }

    @Test
    void get_whenFound_shouldReturnTask() {
        when(repo.findById(1L)).thenReturn(Optional.of(task));

        Task result = service.get(1L);

        assertEquals("Titel", result.getTitle());
        verify(repo).findById(1L);
    }

    @Test
    void get_whenNotFound_shouldThrowException() {
        when(repo.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.get(99L));
    }

    @Test
    void getAll_shouldReturnAllTasks() {
        Task task2 = new Task("Titel2", "Beschreibung2", "DONE", "LOW");
        when(repo.findAll()).thenReturn(List.of(task, task2));

        List<Task> result = service.getAll();

        assertEquals(2, result.size());
    }

    @Test
    void delete_shouldCallRepositoryDeleteById() {
        service.delete(1L);

        verify(repo, times(1)).deleteById(1L);
    }

    @Test
    void updateStatus_whenFound_shouldUpdateAndReturnTask() {
        when(repo.findById(1L)).thenReturn(Optional.of(task));
        when(repo.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Task result = service.updateStatus(1L, "DONE");

        assertEquals("DONE", result.getStatus());
        verify(repo).save(task);
    }

    @Test
    void updateStatus_whenNotFound_shouldThrowException() {
        when(repo.findById(42L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.updateStatus(42L, "DONE"));
    }

    @Test
    void deleteAll_shouldCallRepositoryDeleteAll() {
        service.deleteAll();

        verify(repo, times(1)).deleteAll();
    }

    @Test
    void updateTaskDetails_whenFound_shouldUpdateTitleAndDescription() {
        Task updated = new Task("Neuer Titel", "Neue Beschreibung", "OPEN", "HIGH");
        when(repo.findById(1L)).thenReturn(Optional.of(task));
        when(repo.save(any(Task.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Task result = service.updateTaskDetails(1L, updated);

        assertEquals("Neuer Titel", result.getTitle());
        assertEquals("Neue Beschreibung", result.getDescription());
    }

    @Test
    void updateTaskDetails_whenNotFound_shouldThrowException() {
        when(repo.findById(7L)).thenReturn(Optional.empty());
        Task updated = new Task("X", "Y", "OPEN", "LOW");

        assertThrows(RuntimeException.class, () -> service.updateTaskDetails(7L, updated));
    }
}