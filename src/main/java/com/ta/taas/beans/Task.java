package com.ta.taas.beans;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false,name = "task_group")
    private String group;
    @Column(nullable = false)
    private boolean completed;
    @Column(name = "task_when")
    private Timestamp when;

    @ManyToOne
    @ToString.Exclude
    private User user;
}
