package com.scorenerds.ScoreNerds.dto;

import com.scorenerds.ScoreNerds.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TeamDTO {

    private String name;
    private String sport;

    public TeamDTO(Team team) {
        this.name = team.getName();
        this.sport = team.getSport().getName();
    }

}
