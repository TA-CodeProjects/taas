package com.ta.taas.controllers;

import com.ta.taas.dto.TaskDto;
import com.ta.taas.dto.TaskPayloadDto;
import com.ta.taas.exceptions.TaskSecurityException;
import com.ta.taas.exceptions.TaskSystemException;
import com.ta.taas.security.TokenManger;
import com.ta.taas.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final TokenManger tokenManger;

//    @GetMapping("/{userId}/tasks")
//    public List<TaskDto> getAllTasks(@PathVariable int userId) {
//        return userService.getAllTasks(userId);
//    }
//
//    @PostMapping("/{userId}/tasks")
//    public void addTask(@PathVariable int userId, @RequestBody TaskDto taskDto) throws TaskSystemException {
//        userService.addTask(userId, taskDto);
//    }


    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks(@RequestHeader("Authorization") UUID token) throws TaskSecurityException {
        int userId = tokenManger.getUserId(token);
        return userService.getAllTasks(userId);
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto addTask(@RequestHeader("Authorization") UUID token, @RequestBody TaskDto taskDto) throws TaskSystemException, TaskSecurityException {
        int userId = tokenManger.getUserId(token);
        return userService.addTask(userId, taskDto);
    }

    @PutMapping("/tasks/{id}")
    public TaskDto updateTask(@RequestHeader("Authorization") UUID token, @PathVariable int id, @RequestBody TaskDto taskDto) throws TaskSystemException, TaskSecurityException {
        int userId = tokenManger.getUserId(token);
        return userService.updateTask(userId, id, taskDto);
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@RequestHeader("Authorization") UUID token, @PathVariable int id) throws TaskSecurityException, TaskSystemException {
        int userId = tokenManger.getUserId(token);
        userService.deleteTask(userId, id);
    }


}
