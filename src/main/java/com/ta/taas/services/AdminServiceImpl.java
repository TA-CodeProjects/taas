package com.ta.taas.services;

import com.ta.taas.dto.TaskDto;
import com.ta.taas.dto.UserDto;
import com.ta.taas.exceptions.ErrMsg;
import com.ta.taas.exceptions.TaskSystemException;
import com.ta.taas.mapper.TaskMapper;
import com.ta.taas.mapper.UserMapper;
import com.ta.taas.repos.TaskRepository;
import com.ta.taas.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;
    private final UserMapper userMapper;

    @Override
    public int countUsers(String email) throws TaskSystemException {
        authorized(email);
        return (int) userRepository.count();
    }

    @Override
    public int countTasks(String email) throws TaskSystemException {
        authorized(email);
        return (int) taskRepository.count();
    }

    @Override
    public List<TaskDto> getAllTasks(String email) throws TaskSystemException {
        authorized(email);
        return taskMapper.toDtoList(taskRepository.findAll());
    }

    @Override
    public List<UserDto> getAllUsers(String email) throws TaskSystemException {
        authorized(email);
        return userMapper.toDtoList(userRepository.findAll());
    }

    private void authorized(String email) throws TaskSystemException {
        if (!email.equals("admin@admin.com")) {
            throw new TaskSystemException(ErrMsg.NOT_AUTHORIZED);
        }
    }
}
