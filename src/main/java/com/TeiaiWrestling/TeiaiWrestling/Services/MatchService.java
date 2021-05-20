package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Match;

import java.util.List;

public interface MatchService {

    List<Match> findAllMatches();

    void updateMatch(Match match);

}
