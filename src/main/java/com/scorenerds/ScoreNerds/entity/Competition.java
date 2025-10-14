package com.scorenerds.ScoreNerds.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COMPETITION")
public class Competition {
    @Id
    @Column(name = "COMPETITION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "COMPETITION_NAME")
    private String name;

    @OneToMany(mappedBy = "competition")
    private List<Contest> contests;
}
