package com.TeiaiWrestling.TeiaiWrestling.Services;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Wrestler;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.WrestlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;

@Service
public class WrestlerServiceImp implements WrestlerService{

    @Autowired
    WrestlerRepository wrestlerRepository;

    @Autowired
    ComparatorService comparatorService;

    @Override
    public TreeSet<Wrestler> findAllAndOrder() {
        TreeSet<Wrestler> wrestlerTreeSet = new TreeSet<>(comparatorService);
        wrestlerTreeSet.addAll(wrestlerRepository.findAll());
        return wrestlerTreeSet;
    }

    @Override
    public TreeSet<Wrestler> findAllAByGender(String gender) {
        TreeSet<Wrestler> wrestlerTreeSet = new TreeSet<>(comparatorService);
        if(gender.equals("ALL")){
            wrestlerTreeSet.addAll(wrestlerRepository.findAll());
        }else{
            wrestlerTreeSet.addAll(wrestlerRepository.findAllBySex(gender));
        }
        return wrestlerTreeSet;
    }
}
