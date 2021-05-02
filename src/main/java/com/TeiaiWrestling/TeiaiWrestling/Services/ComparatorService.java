package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Wrestler;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class ComparatorService implements Comparator<Wrestler> {

    @Override
    public int compare(Wrestler wrestler1, Wrestler wrestler2) {
        return wrestler1.getWrestlerName().compareTo(wrestler2.getWrestlerName());
    }
}
