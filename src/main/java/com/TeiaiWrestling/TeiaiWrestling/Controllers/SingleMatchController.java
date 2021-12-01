package com.TeiaiWrestling.TeiaiWrestling.Controllers;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Match;
import com.TeiaiWrestling.TeiaiWrestling.Entities.WrestlingCard;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.MatchRepository;
import com.TeiaiWrestling.TeiaiWrestling.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SingleMatchController {

    @Autowired
    TypeMatchService typeMatchService;

    @Autowired
    WrestlerService wrestlerService;

    @Autowired
    MatchRepository matchRepository;

    @Autowired
    UpdateScores updateScores;

    @Autowired
    WrestlingCardService wrestlingCardService;

    @GetMapping(value = "/singlematch")
    public ModelAndView showMatchesPage(){
        ModelAndView map = new ModelAndView("singlematch");
        map.addObject("matchtypelist",typeMatchService.findAll());
        map.addObject("wrestlernames",wrestlerService.findAllAndOrder());
        return map;
    }


    @PostMapping(value = "/singlematch")
    public ModelAndView updateSinglesData(@RequestParam String victory,@RequestParam String loss, boolean draw){
        ModelAndView map = new ModelAndView("singlematch");
        List<WrestlingCard> wrestlingCardList = wrestlingCardService.findAllByWrestlerName(victory,loss);
        Match matchStats = new Match();
        if (!draw) {
            matchStats.setWinner(victory);
            matchStats.setLoser(loss);
            updateScores.addVictory(victory);
            updateScores.addLoss(loss);
        }else{
            matchStats.setDraw1(victory);
            matchStats.setDraw2(loss);
            updateScores.addDraws(victory,loss);
        }
        matchStats.setMatchType(typeMatchService.findMatchByName("Single"));
        matchStats.setWrestlingCardList(wrestlingCardList);
        matchRepository.save(matchStats);
        map.addObject("message",0);
        map.addObject("matchtypelist",typeMatchService.findAll());
        map.addObject("wrestlernames",wrestlerService.findAllAndOrder());
        return map;
    }


}
