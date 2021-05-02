package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.WrestlingCard;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.WrestlingCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
