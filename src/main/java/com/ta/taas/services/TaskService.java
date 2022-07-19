package com.ta.taas.services;

import com.ta.taas.dto.TaskDto;
import com.ta.taas.exceptions.TaskSystemException;

import java.sql.Timestamp;
import java.util.List;

public interface TaskService {
    TaskDto addTask(TaskDto taskDto) throws TaskSystemException;
    void updateTask(int taskId,TaskDto taskDto) throws TaskSystemException;
    void deleteTask(int taskId) throws TaskSystemException;

    List<TaskDto> getAllTasks();
    TaskDto getOneTask(int taskId) throws TaskSystemException;

    int count();

    List<TaskDto> getAllTaskOrderByTimeAsc();
    List<TaskDto> getAllTaskOrderByTimeDesc();
    List<TaskDto> getAllTasksBetween(Timestamp startDate, Timestamp endDate) throws TaskSystemException;

}
