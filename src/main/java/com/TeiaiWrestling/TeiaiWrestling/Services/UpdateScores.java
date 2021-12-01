package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.WrestlingCard;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.WrestlingCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateScores {

    @Autowired
    WrestlingCardRepository wrestlingCardRepository;

    @Autowired
    WrestlingCardService wrestlingCardService;

    @Autowired
    CheckStreakService checkStreakService;


    public static final int ADDEDVALUE = 1;

    public void addVictory(String wrestlerName){
        System.out.println("Enter add victory");
        WrestlingCard wrestlingCard = wrestlingCardRepository.findWrestlingCardByWrestlerWrestlerName(wrestlerName);
        wrestlingCard.setNumberVictories(wrestlingCard.getNumberVictories() + ADDEDVALUE);
        checkStreakService.CheckStreak(wrestlingCard,0);
        wrestlingCardService.updateWrestler(wrestlerName);
        System.out.println("Wrestler Updated");
    }

    public void addLoss(String wrestlerName){
        System.out.println("Enter add loss");
        WrestlingCard wrestlingCard = wrestlingCardRepository.findWrestlingCardByWrestlerWrestlerName(wrestlerName);
        wrestlingCard.setNumberLosses(wrestlingCard.getNumberLosses() + ADDEDVALUE);
        checkStreakService.CheckStreak(wrestlingCard,1);
        wrestlingCardService.updateWrestler(wrestlerName);
        System.out.println("Wrestler Updated");
    }

    public void addDraws(String wrestler1, String wrestler2){
        List<WrestlingCard> wrestlingCardList = wrestlingCardService.findAllByWrestlerName(wrestler1,wrestler2);
        for(WrestlingCard wrestlingCard: wrestlingCardList){
            wrestlingCard.setDraw(wrestlingCard.getDraw() + ADDEDVALUE);
            wrestlingCardService.updateWrestler(wrestlingCard.getWrestler().getWrestlerName());
            checkStreakService.CheckStreak(wrestlingCard,3);
        }
        wrestlingCardService.updateWrestler(wrestler2);
    }

}
