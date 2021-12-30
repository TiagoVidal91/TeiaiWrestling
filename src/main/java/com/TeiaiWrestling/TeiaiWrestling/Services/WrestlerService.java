package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Wrestler;

import java.util.List;
import java.util.TreeSet;

public interface WrestlerService {

    TreeSet<Wrestler> findAllAndOrder();

    TreeSet<Wrestler> findAllAByGender(String gender);
}
