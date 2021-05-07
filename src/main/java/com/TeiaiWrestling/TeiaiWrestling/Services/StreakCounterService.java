package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.WrestlingCard;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.WrestlingCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StreakCounterService {

    @Autowired
    WrestlingCardService wrestlingCardService;

    @Autowired
    WrestlingCardRepository wrestlingCardRepository;

    @Autowired
    CheckStreakService checkStreakService;

    public static final int DEFAULTSTREAKVALUE=0;

    public void streakCount(int selectScoreType, String wrestlerName){
        WrestlingCard wrestlingCard = wrestlingCardRepository.
                findWrestlingCardByWrestlerWrestlerName(wrestlerName);
        checkStreakService.CheckStreak(wrestlingCard,selectScoreType);
    }

}
