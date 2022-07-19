package com.ta.taas.services;

import com.ta.taas.dto.TaskDto;
import com.ta.taas.exceptions.TaskSystemException;

import java.util.List;

public interface UserService {

    List<TaskDto> getAllTasks(int userId);
    TaskDto addTask(int userId, TaskDto taskDto) throws TaskSystemException;
    TaskDto updateTask(int userId,int id, TaskDto taskDto) throws TaskSystemException;
    void deleteTask(int userId, int taskId) throws TaskSystemException;
}
