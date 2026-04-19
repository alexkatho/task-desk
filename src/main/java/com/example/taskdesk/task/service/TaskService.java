package com.example.taskdesk.task.service;

import com.example.taskdesk.task.domain.TaskEntity;
import com.example.taskdesk.task.dto.TaskCreateRequestDto;
import com.example.taskdesk.task.dto.TaskResponseDto;
import com.example.taskdesk.task.mapper.TaskMapper;
import com.example.taskdesk.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service-Schicht für Tasks.
 *
 * Hier bündeln wir die Anwendungslogik.
 * Im Moment ist sie noch klein,
 * aber diese Struktur ist bereits sauber und erweiterbar.
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    /**
     * Lädt alle Tasks aus der Datenbank
     * und mappt sie in Response-DTOs.
     */
    public List<TaskResponseDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toResponseDto)
                .toList();
    }

    /**
     * Erstellt eine neue Task.
     *
     * Der Ablauf ist:
     * 1. Request DTO -> Entity
     * 2. Entity speichern
     * 3. gespeicherte Entity -> Response DTO
     */
    public TaskResponseDto createTask(TaskCreateRequestDto requestDto) {
        TaskEntity entity = taskMapper.toEntity(requestDto);
        TaskEntity savedEntity = taskRepository.save(entity);
        return taskMapper.toResponseDto(savedEntity);
    }
}