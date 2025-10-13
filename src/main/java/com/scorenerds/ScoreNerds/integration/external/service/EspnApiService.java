package com.scorenerds.ScoreNerds.integration.external.service;

import com.scorenerds.ScoreNerds.dto.LeagueDTO;
import com.scorenerds.ScoreNerds.dto.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EspnApiService {

    public EspnApiService() {}

    public LeagueDTO getLeague(Object response) {
        return new LeagueDTO();
    }

    public List<TeamDTO> getTeams(Object response) {
        return new ArrayList<>();
    }

}
