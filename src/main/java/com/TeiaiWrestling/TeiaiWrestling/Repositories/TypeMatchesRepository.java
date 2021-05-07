package com.TeiaiWrestling.TeiaiWrestling.Repositories;

import com.TeiaiWrestling.TeiaiWrestling.Entities.MatchType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeMatchesRepository extends JpaRepository<MatchType, Long> {

    @Override
    List<MatchType> findAll();
}
