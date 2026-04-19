package com.example.taskdesk.task.presentation;

import com.example.taskdesk.task.dto.TaskCreateRequestDto;
import com.example.taskdesk.task.dto.TaskResponseDto;
import com.example.taskdesk.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für Task-Endpunkte.
 *
 * Diese Klasse bildet den Presentation Layer.
 * Sie ist verantwortlich für HTTP,
 * nicht für Geschäftslogik oder DB-Details.
 */
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * GET /api/tasks
     *
     * Liefert alle Tasks.
     */
    @GetMapping
    public List<TaskResponseDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * POST /api/tasks
     *
     * Erwartet ein gültiges JSON-Objekt für eine neue Task.
     * @Valid aktiviert Bean Validation auf dem DTO.
     */
    @PostMapping
    public TaskResponseDto createTask(@Valid @RequestBody TaskCreateRequestDto requestDto) {
        return taskService.createTask(requestDto);
    }
}