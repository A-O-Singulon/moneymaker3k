package com.scorenerds.ScoreNerds.repository;

import com.scorenerds.ScoreNerds.entity.Sport;
import com.scorenerds.ScoreNerds.entity.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

    @NonNull
    List<Team> findAll();

    Boolean existsByNameAndSport(String name, Sport sport);

    @Query(
            "SELECT t.name From Team t " +
            "WHERE t.sport = :sport "
    )
    List<String> findsNamesBySport(Sport sport);

}
