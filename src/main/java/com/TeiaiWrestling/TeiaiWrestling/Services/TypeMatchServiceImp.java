package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.MatchType;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.TypeMatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeMatchServiceImp implements TypeMatchService{

    @Autowired
    TypeMatchesRepository typeMatchesRepository;

    @Override
    public List<MatchType> findAll() {
        return typeMatchesRepository.findAll();
    }

    @Override
    public MatchType findMatchByName(String matchName) {
        return typeMatchesRepository.findByName(matchName);
    }
}
