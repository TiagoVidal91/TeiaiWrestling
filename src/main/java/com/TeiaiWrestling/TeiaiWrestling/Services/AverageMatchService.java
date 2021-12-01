package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.WrestlingCard;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.WrestlingCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class AverageMatchService {

    @Autowired
    WrestlingCardRepository wrestlingCardRepository;

    public void calculateAverage(){

        for(WrestlingCard wrestlingCard: wrestlingCardRepository.findAll()){

            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            double totalAverage = 0;

            if(wrestlingCard.getNumberVictories()==0 || wrestlingCard.getTotalMatches()==0){
            }else{
               totalAverage = ((double) wrestlingCard.getNumberVictories()/wrestlingCard.getTotalMatches())*100;

                wrestlingCard.setTotalAverage(decimalFormat.format(totalAverage));
            }
        }
    }
}