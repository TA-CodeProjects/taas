package com.ta.taas.controllers;

import com.ta.taas.dto.TaskDto;
import com.ta.taas.dto.UserDto;
import com.ta.taas.exceptions.TaskSecurityException;
import com.ta.taas.exceptions.TaskSystemException;
import com.ta.taas.security.TokenManger;
import com.ta.taas.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AdminController {
    private final AdminService adminService;
    private final TokenManger tokenManger;

    @GetMapping("tasks/count")
    public int countTasks(@RequestHeader("Authorization") UUID token) throws TaskSecurityException, TaskSystemException {
        String email = tokenManger.getEmail(token);
        return adminService.countTasks(email);
    }

    @GetMapping("users/count")
    public int countUsers(@RequestHeader("Authorization") UUID token) throws TaskSecurityException, TaskSystemException {
        String email = tokenManger.getEmail(token);
        return adminService.countUsers(email);
    }

    @GetMapping("tasks")
    public List<TaskDto> getAllTasks(@RequestHeader("Authorization") UUID token) throws TaskSecurityException, TaskSystemException {
        String email = tokenManger.getEmail(token);
        return adminService.getAllTasks(email);
    }

    @GetMapping("users")
    public List<UserDto> getAllUsers(@RequestHeader("Authorization") UUID token) throws TaskSecurityException, TaskSystemException {
        String email = tokenManger.getEmail(token);
        return adminService.getAllUsers(email);
    }
}
