package com.scorenerds.ScoreNerds.service.general;

import com.scorenerds.ScoreNerds.entity.Sport;
import com.scorenerds.ScoreNerds.entity.Team;
import com.scorenerds.ScoreNerds.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveTeam(Team team) {
        if (teamRepository.existsByNameAndSport(team.getName(), team.getSport())) {
            throw new IllegalArgumentException("Team already exists");
        }
        try {
            teamRepository.save(team);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<String> teamNamesBySport(Sport sport) {
        return teamRepository.findsNamesBySport(sport);
    }

}
