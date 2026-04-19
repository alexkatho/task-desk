package com.example.taskdesk.task.mapper;

import com.example.taskdesk.task.domain.TaskEntity;
import com.example.taskdesk.task.dto.TaskCreateRequestDto;
import com.example.taskdesk.task.dto.TaskResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskEntity toEntity(TaskCreateRequestDto dto) {
        TaskEntity entity = new TaskEntity();
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setStatus(dto.status());
        return entity;
    }

    public TaskResponseDto toResponseDto(TaskEntity entity) {
        return new TaskResponseDto(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus()
        );
    }
}	