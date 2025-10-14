package com.scorenerds.ScoreNerds.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CONTEST")
public class Contest {
    @Id
    @Column(name = "CONTEST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID_A")
    private Team teamA;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID_B")
    private Team teamB;

    @Column(name = "SCORE_A")
    private int scoreA;

    @Column(name = "SCORE_B")
    private int scoreB;

    @ManyToOne
    @JoinColumn(name = "COMPETITION_ID")
    private Competition competition;
}
