package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.WrestlingCard;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.WrestlingCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WrestlingCardServiceImp implements WrestlingCardService{

    @Autowired
    WrestlingCardRepository wrestlingCardRepository;

    @Override
    public List<WrestlingCard> findAll() {
        return wrestlingCardRepository.findAll();
    }

    @Override
    public void updateWrestler(String wrestlerName) {
        wrestlingCardRepository.save(
                wrestlingCardRepository.findWrestlingCardByWrestlerWrestlerName(
                        wrestlerName));
    }

    @Override
    public List<WrestlingCard> findAllByWrestlerName(String wrestlerName1, String wrestlerName2) {
        List<WrestlingCard> wrestlingCardList = new ArrayList<>();
        wrestlingCardList.add(wrestlingCardRepository.findWrestlingCardByWrestlerWrestlerName(wrestlerName1));
        wrestlingCardList.add(wrestlingCardRepository.findWrestlingCardByWrestlerWrestlerName(wrestlerName2));
        return wrestlingCardList;
    }
}
