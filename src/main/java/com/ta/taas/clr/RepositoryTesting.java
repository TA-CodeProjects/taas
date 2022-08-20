package com.ta.taas.clr;

import com.ta.taas.beans.ClientType;
import com.ta.taas.beans.Task;
import com.ta.taas.beans.User;
import com.ta.taas.repos.TaskRepository;
import com.ta.taas.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(1)
public class RepositoryTesting implements CommandLineRunner {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = User.builder()
                .email("admin@admin.com")
                .password("admin")
                .type(ClientType.ADMIN)
                .build();

        User u2 = User.builder()
                .email("ariel@gmail.com")
                .password("1234")
                .type(ClientType.USER)
                .build();

        User u3 = User.builder()
                .email("bar@gmail.com")
                .password("1234")
                .type(ClientType.USER)
                .build();

        Task t1 = Task
                .builder()
                .group("Spring")
                .title("Cat & Toys Ex")
                .description("Spring Homework")
                .completed(false)
                .when(Timestamp.valueOf(LocalDateTime.now().plusWeeks(2)))
                .user(u2)
                .build();

        Task t2 = Task
                .builder()
                .group("Spring")
                .title("Author & Books Ex")
                .description("Spring Homework")
                .completed(false)
                .when(Timestamp.valueOf(LocalDateTime.now().plusWeeks(2)))
                .user(u2)
                .build();


        Task t3 = Task
                .builder()
                .group("Spring")
                .title("prepare for Spring Exam")
                .description("Spring Homework")
                .completed(false)
                .when(Timestamp.valueOf(LocalDateTime.of(2022,5,26,15,25)))
                .user(u3)
                .build();


        u2.setTasks(Arrays.asList(t1,t2));
        u3.setTasks(List.of(t3));

//        taskRepository.saveAll(Arrays.asList(t1,t2,t3));
//        taskRepository.findAll().forEach(System.out::println);
        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        userRepository.findAll().forEach(System.out::println);

    }
}
