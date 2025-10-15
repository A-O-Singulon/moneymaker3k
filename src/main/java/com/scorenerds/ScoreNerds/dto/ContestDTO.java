package com.scorenerds.ScoreNerds.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContestDTO {

    private TeamDTO teamA;
    private Integer scoreA;
    private TeamDTO teamB;
    private Integer scoreB;

}
