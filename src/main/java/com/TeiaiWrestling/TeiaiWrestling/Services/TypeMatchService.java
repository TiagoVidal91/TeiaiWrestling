package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.MatchType;

import java.util.List;

public interface TypeMatchService {

    List<MatchType> findAll();

    MatchType findMatchByName(String matchName);

}
