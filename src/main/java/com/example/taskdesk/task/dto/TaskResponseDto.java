package com.example.taskdesk.task.dto;

import com.example.taskdesk.task.domain.TaskStatus;

/**
 * Record für API-Response.
 *
 * Immutable, klar definiert und perfekt für JSON.
 */
public record TaskResponseDto(
        Long id,
        String title,
        String description,
        TaskStatus status
) {
}