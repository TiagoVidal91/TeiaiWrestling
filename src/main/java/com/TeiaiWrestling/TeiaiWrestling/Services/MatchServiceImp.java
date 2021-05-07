package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Match;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MatchServiceImp implements MatchService{

    @Autowired
    MatchRepository matchRepository;

    @Override
    public List<Match> findAllMatches() {
        return matchRepository.findAll();
    }
}
