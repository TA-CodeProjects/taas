package com.ta.taas.mapper;

import com.ta.taas.beans.Task;
import com.ta.taas.dto.TaskDto;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper implements Mapper<Task, TaskDto> {
    @Override
    public Task toDao(TaskDto taskDto) {
        return Task.builder()
                .description(taskDto.getInfo())
                .group(taskDto.getClassification())
                .title(taskDto.getCaption())
                .id(taskDto.getId())
                .when(Timestamp.valueOf(taskDto.getDueDate()))
                .build();
    }

    @Override
    public TaskDto toDto(Task task) {
        return TaskDto.builder()
                .caption(task.getTitle())
                .id(task.getId())
                .dueDate(task.getWhen().toLocalDateTime())
                .classification(task.getGroup())
                .info(task.getDescription())
                .build();
    }

    @Override
    public List<Task> toDaoList(List<TaskDto> taskDtos) {
        return taskDtos.stream().map(this::toDao).collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> toDtoList(List<Task> tasks) {
        return tasks.stream().map(this::toDto).collect(Collectors.toList());
    }
}
