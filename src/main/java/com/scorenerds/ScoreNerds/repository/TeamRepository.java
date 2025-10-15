package com.scorenerds.ScoreNerds.repository;

import com.scorenerds.ScoreNerds.entity.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
}
