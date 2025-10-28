package com.scorenerds.ScoreNerds.integration.external.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspnDataDTO {

    private List<LeagueDTO> leagues;
    private List<EventDTO> events;

}
