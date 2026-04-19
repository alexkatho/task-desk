package com.example.taskdesk.task.dto;

import com.example.taskdesk.task.domain.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Record für Create-Request.
 *
 * Vorteile:
 * - immutable
 * - kein Boilerplate (Getter, Constructor)
 * - perfekt für API-Eingaben
 */
public record TaskCreateRequestDto(

        @NotBlank(message = "Title must not be blank")
        @Size(max = 255, message = "Title must not exceed 255 characters")
        String title,

        @Size(max = 1000, message = "Description must not exceed 1000 characters")
        String description,

        @NotNull(message = "Status must not be null")
        TaskStatus status

) {
}