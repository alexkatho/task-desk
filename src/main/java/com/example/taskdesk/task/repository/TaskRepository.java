package com.example.taskdesk.task.repository;

import com.example.taskdesk.task.domain.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository für den Zugriff auf Task-Daten.
 *
 * Spring Data JPA erzeugt die Implementierung automatisch.
 */
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}