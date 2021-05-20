package com.TeiaiWrestling.TeiaiWrestling.Controllers;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Match;
import com.TeiaiWrestling.TeiaiWrestling.Repositories.MatchRepository;
import com.TeiaiWrestling.TeiaiWrestling.Services.TypeMatchService;
import com.TeiaiWrestling.TeiaiWrestling.Services.WrestlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SingleMatchController {

    @Autowired
    TypeMatchService typeMatchService;

    @Autowired
    WrestlerService wrestlerService;

    @Autowired
    MatchRepository matchRepository;

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
        Match matchStats = new Match();
        if (draw) {
            matchStats.setDraw1(victory);
            matchStats.setDraw2(loss);
        }else{
            matchStats.setWinner(victory);
            matchStats.setLoser(loss);
        }
        matchStats.setMatchType(typeMatchService.findMatchByName("Single"));

        return null;
    }


}
