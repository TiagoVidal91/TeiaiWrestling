package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.WrestlingCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchCountingService {

    @Autowired
    WrestlingCardService wrestlingCardService;

    public void returnMatchCount(){
        for(WrestlingCard wrestlingCard: wrestlingCardService.findAll()){
            wrestlingCard.setTotalMatches(wrestlingCard.getNumberVictories()+
                    wrestlingCard.getDraw()+wrestlingCard.getNumberLosses()+wrestlingCard.getNoWin());
        }
    }
}
