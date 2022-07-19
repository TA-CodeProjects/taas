package com.ta.taas.beans;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(unique = true)
    private String email;
    @Size(min = 4, max = 20)
    private String password;
    @Enumerated(EnumType.STRING)
    private ClientType type;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    @Singular
    private List<Task> tasks = new ArrayList<>();
}
