package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.WrestlingCard;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WrestlingCardService {

    List<WrestlingCard> findAll();

    void updateWrestler(String wrestlerName);
}
