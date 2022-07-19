package com.ta.taas.repos;

import com.ta.taas.beans.Task;
import com.ta.taas.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByOrderByWhenAsc();
    List<Task> findByOrderByWhenDesc();
    List<Task> findByWhenBetween(Timestamp start, Timestamp end);
    boolean existsByIdAndUser(int id, User user);

    List<Task> findByUserId(int userId);
}
