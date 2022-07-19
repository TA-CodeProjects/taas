package com.ta.taas.services;

import com.ta.taas.dto.TaskDto;
import com.ta.taas.dto.UserDto;
import com.ta.taas.exceptions.TaskSystemException;

import java.util.List;

public interface AdminService {

    int countUsers(String email) throws TaskSystemException;
    int countTasks(String email) throws TaskSystemException;
    List<TaskDto> getAllTasks(String email) throws TaskSystemException;
    List<UserDto> getAllUsers(String email) throws TaskSystemException;
}
