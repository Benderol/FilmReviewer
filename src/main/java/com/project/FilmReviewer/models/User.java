package com.project.FilmReviewer.models;

import com.project.FilmReviewer.models.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String username;

    @Column(length = 1000)
    private String password;

    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SortedSet<Film> films = new TreeSet<>();

}
