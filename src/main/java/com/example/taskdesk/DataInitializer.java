package com.example.taskdesk;

import com.example.taskdesk.task.domain.TaskEntity;
import com.example.taskdesk.task.domain.TaskStatus;
import com.example.taskdesk.task.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Legt beim ersten Start Demo-Daten an,
 * wenn die Tabelle noch leer ist.
 */
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(TaskRepository taskRepository) {
        return args -> {
            if (taskRepository.count() == 0) {
                taskRepository.save(new TaskEntity(
                        "Spring Boot Projekt aufsetzen",
                        "Backend mit PostgreSQL und JPA vorbereiten",
                        TaskStatus.DONE
                ));

                taskRepository.save(new TaskEntity(
                        "REST API erstellen",
                        "GET und POST Endpoint für Tasks bereitstellen",
                        TaskStatus.IN_PROGRESS
                ));

                taskRepository.save(new TaskEntity(
                        "Angular anbinden",
                        "Frontend soll echte Daten laden",
                        TaskStatus.TODO
                ));
            }
        };
    }
}