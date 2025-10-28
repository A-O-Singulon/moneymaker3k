package com.scorenerds.ScoreNerds.service.general;

import com.scorenerds.ScoreNerds.entity.Sport;
import com.scorenerds.ScoreNerds.repository.SportRepository;
import org.springframework.stereotype.Service;

@Service
public class SportService {

    // TODO: think of a way to automatically fill the sport table with all the supported sports
    private final SportRepository sportRepository;

    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public Sport getSportByName(String name) {
        return sportRepository.findSportByName(name);
    }

}
