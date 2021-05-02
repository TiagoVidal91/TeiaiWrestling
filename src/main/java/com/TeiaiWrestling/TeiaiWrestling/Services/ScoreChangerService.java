package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Repositories.WrestlingCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreChangerService {

    @Autowired
    WrestlingCardRepository wrestlingCardRepository;

    @Autowired
    WrestlingCardService wrestlingCardService;

    public static final int ADDEDVALUE = 1;

    public void changeScore(int selectScoreType, String wrestlerName) {
        System.out.println(selectScoreType);
        System.out.println(wrestlerName);
        if (selectScoreType == ScoreTypes.WINS.ordinal()) {
            wrestlingCardRepository.findWrestlingCardByWrestlerWrestlerName(wrestlerName).setNumberVictories(wrestlingCardRepository.
                    findWrestlingCardByWrestlerWrestlerName(wrestlerName).
                    getNumberVictories() + ADDEDVALUE);
        } else if (selectScoreType == ScoreTypes.LOSS.ordinal()){
            wrestlingCardRepository.findWrestlingCardByWrestlerWrestlerName(wrestlerName).
                    setNumberLosses(wrestlingCardRepository.
                    findWrestlingCardByWrestlerWrestlerName(wrestlerName).
                    getNumberLosses() + ADDEDVALUE);
        } else if(selectScoreType == ScoreTypes.DRAW.ordinal()){
            wrestlingCardRepository.findWrestlingCardByWrestlerWrestlerName(wrestlerName).
                    setDraw(wrestlingCardRepository.
                    findWrestlingCardByWrestlerWrestlerName(wrestlerName).
                    getDraw() + ADDEDVALUE);
        }else if(selectScoreType == ScoreTypes.NOWIN.ordinal()){
            wrestlingCardRepository.findWrestlingCardByWrestlerWrestlerName(wrestlerName).
                    setNoWin(wrestlingCardRepository.
                    findWrestlingCardByWrestlerWrestlerName(wrestlerName).
                    getNoWin() + ADDEDVALUE);
        }
        wrestlingCardService.updateWrestler(wrestlerName);
    }
}
