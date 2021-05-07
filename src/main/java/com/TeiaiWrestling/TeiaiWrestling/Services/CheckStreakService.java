package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Wrestler;
import com.TeiaiWrestling.TeiaiWrestling.Entities.WrestlingCard;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.WrestlingCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckStreakService {

    @Autowired
    WrestlingCardRepository wrestlingCardRepository;

    public static final int DEFAULTNUMBER=0;
    public static final int VALUETOADD=1;
    public static final int VALUETOSUB=-1;

    public void CheckStreak(WrestlingCard wrestlingCard, int selectScoreType) {

        if (selectScoreType == ScoreTypes.WINS.ordinal()) {
            if(wrestlingCard.getStreak()>=DEFAULTNUMBER){
                wrestlingCard.setStreak(wrestlingCard.getStreak()+VALUETOADD);
            }else{
                wrestlingCard.setStreak(VALUETOADD);
            }
        }else if (selectScoreType == ScoreTypes.LOSS.ordinal())
        {
            if(wrestlingCard.getStreak()<=DEFAULTNUMBER){
                wrestlingCard.setStreak(wrestlingCard.getStreak()+VALUETOSUB);
            }else{
                wrestlingCard.setStreak(VALUETOSUB);
            }
        }
        wrestlingCardRepository.save(wrestlingCard);
    }
}
