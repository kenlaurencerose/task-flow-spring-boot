package de.htwberlin.webtech.taskflow.repository;

import de.htwberlin.webtech.taskflow.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
