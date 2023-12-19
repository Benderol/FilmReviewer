package com.project.FilmReviewer.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Film implements Comparable<Film>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String filmTitle;

    private String userOpinion;

    private float mark;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Override
    public int compareTo(Film film) {
        if(this.mark > film.mark)
            return -1;
        else if (this.mark < film.mark)
            return 1;

        return 0;
    }
}
