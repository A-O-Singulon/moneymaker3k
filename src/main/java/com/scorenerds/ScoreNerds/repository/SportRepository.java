package com.scorenerds.ScoreNerds.repository;

import com.scorenerds.ScoreNerds.entity.Sport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends CrudRepository<Sport, Integer> {

    @Query(
            "SELECT s FROM Sport s " +
            "WHERE LOWER(s.name) LIKE LOWER(:name) "
    )
    public Sport findSportByName(@Param("name") String name);

}
