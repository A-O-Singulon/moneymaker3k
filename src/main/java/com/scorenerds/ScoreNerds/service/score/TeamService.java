package com.scorenerds.ScoreNerds.service.score;

import com.scorenerds.ScoreNerds.dto.TeamDTO;
import com.scorenerds.ScoreNerds.entity.Team;
import com.scorenerds.ScoreNerds.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

}
