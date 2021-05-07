package com.TeiaiWrestling.TeiaiWrestling.Repositories;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Override
    List<Match> findAll();
}
