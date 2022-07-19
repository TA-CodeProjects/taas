package com.ta.taas.services;

import com.ta.taas.beans.Task;
import com.ta.taas.beans.User;
import com.ta.taas.dto.TaskDto;
import com.ta.taas.exceptions.ErrMsg;
import com.ta.taas.exceptions.TaskSystemException;
import com.ta.taas.mapper.TaskMapper;
import com.ta.taas.repos.TaskRepository;
import com.ta.taas.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getAllTasks(int userId) {
        return taskMapper.toDtoList(taskRepository.findByUserId(userId));
    }

    @Override
    public TaskDto addTask(int userId, TaskDto taskDto) throws TaskSystemException {
        Task toAdd = taskMapper.toDao(taskDto);
        User user = userRepository.findById(userId).orElseThrow(() -> new TaskSystemException(ErrMsg.ID_NOT_EXIST));
        toAdd.setUser(user);
       return taskMapper.toDto(taskRepository.save(toAdd));
    }

    @Override
    public TaskDto updateTask(int userId, int taskId, TaskDto taskDto) throws TaskSystemException {
        Task toUpdate = taskMapper.toDao(taskDto);
        User user = userRepository.findById(userId).orElseThrow(() -> new TaskSystemException(ErrMsg.ID_NOT_EXIST));
        toUpdate.setId(taskId);
        toUpdate.setUser(user);
        if (!taskRepository.existsByIdAndUser(taskId, user)){
            throw new TaskSystemException(ErrMsg.ID_NOT_EXIST);
        }
       return taskMapper.toDto(taskRepository.saveAndFlush(toUpdate));

    }

    @Override
    public void deleteTask(int userId, int taskId) throws TaskSystemException {
        User user = userRepository.findById(userId).orElseThrow(() -> new TaskSystemException(ErrMsg.ID_NOT_EXIST));
        if (!taskRepository.existsByIdAndUser(taskId, user)){
            throw new TaskSystemException(ErrMsg.ID_NOT_EXIST);
        }
        taskRepository.deleteById(taskId);
    }


}
