package com.scorenerds.ScoreNerds.integration.external.service;

import com.scorenerds.ScoreNerds.integration.external.dto.CompetitorDTO;
import com.scorenerds.ScoreNerds.integration.external.dto.EspnDataDTO;
import com.scorenerds.ScoreNerds.integration.external.dto.TeamDTO;
import com.scorenerds.ScoreNerds.entity.Sport;
import com.scorenerds.ScoreNerds.entity.Team;
import com.scorenerds.ScoreNerds.service.general.SportService;
import com.scorenerds.ScoreNerds.service.general.TeamService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspnApiService {

    private static final Logger LOG = LoggerFactory.getLogger(EspnApiService.class);

    private final TeamService teamService;
    private final SportService sportService;

    public EspnApiService(TeamService teamService, SportService sportService) {
        this.teamService = teamService;
        this.sportService = sportService;
    }

    public List<TeamDTO> extractTeams(EspnDataDTO espnDataDTO) {
        return espnDataDTO.getEvents().stream()
                .flatMap(event -> event.getCompetitions().stream())
                .flatMap(competition -> competition.getCompetitors().stream())
                .map(CompetitorDTO::getTeam)
                .toList();
    }

    @Transactional
    public void fillDatabase(EspnDataDTO espnDataDTO) {
        Sport sport = sportService.getSportByName("football");
        List<String> teamFilter = teamService.teamNamesBySport(sport);
        extractTeams(espnDataDTO)
                .stream().filter(teamDTO -> !teamFilter.contains(teamDTO.getName()))
                .forEach(teamDTO -> fillTeam(teamDTO, sport));
    }

    private void fillTeam(TeamDTO teamDTO, Sport sport) {
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setSport(sport);
        LOG.info("Adding {} team: {}", sport.getName(), teamDTO.getName());

        try {
            teamService.saveTeam(team);
        } catch (Exception e) {
            LOG.warn(e.getMessage());
        }
    }


}
