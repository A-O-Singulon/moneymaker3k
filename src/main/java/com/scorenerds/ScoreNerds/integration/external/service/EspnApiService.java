package com.scorenerds.ScoreNerds.integration.external.service;

import com.scorenerds.ScoreNerds.dto.EspnDataDTO;
import com.scorenerds.ScoreNerds.dto.LeagueDTO;
import com.scorenerds.ScoreNerds.dto.TeamDTO;
import com.scorenerds.ScoreNerds.entity.Team;
import com.scorenerds.ScoreNerds.service.score.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EspnApiService {

    private final TeamService teamService;

    public EspnApiService(TeamService teamService) {
        this.teamService = teamService;
    }

    public void fillDatabase(EspnDataDTO espnDataDTO) {
        espnDataDTO.getEvents().forEach(event -> {
            event.getCompetitions().forEach(competition -> {
                competition.getCompetitors().forEach(competitor -> {
                    fillTeam(competitor.getTeam());
                });
            });
        });
    }

    private void fillTeam(TeamDTO teamDTO) {
        Team team = new Team();
        team.setName(teamDTO.getName());

        teamService.saveTeam(team);
    }


}
