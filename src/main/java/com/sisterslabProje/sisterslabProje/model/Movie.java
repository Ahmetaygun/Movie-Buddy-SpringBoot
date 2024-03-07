package com.sisterslabProje.sisterslabProje.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date releaseDate;
    private int rating;


    @ManyToMany(mappedBy = "watchlist")
    private List<User> users;
}
