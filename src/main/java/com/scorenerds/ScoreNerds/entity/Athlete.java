package com.scorenerds.ScoreNerds.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ATHLETE")
public class Athlete {
    @Id
    @Column(name = "ATHLETE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ATHLETE_NAME", length = 200)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SPORT_ID")
    private Sport sport;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
}
