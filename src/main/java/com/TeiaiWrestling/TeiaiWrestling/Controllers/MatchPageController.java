package com.TeiaiWrestling.TeiaiWrestling.Controllers;

import com.TeiaiWrestling.TeiaiWrestling.Services.AverageMatchService;
import com.TeiaiWrestling.TeiaiWrestling.Services.ScoreChangerService;
import com.TeiaiWrestling.TeiaiWrestling.Services.StreakCounterService;
import com.TeiaiWrestling.TeiaiWrestling.Services.WrestlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MatchPageController {

    @Autowired
    WrestlerService wrestlerService;

    @Autowired
    ScoreChangerService scoreChangerService;

    @Autowired
    StreakCounterService streakCounterService;

    @GetMapping(value = "/resultsmatches")
    public ModelAndView showMatchPage(){
        ModelAndView map = new ModelAndView("resultsmatches");
        map.addObject("wrestlerList",wrestlerService.findAllAndOrder());
        return map;
    }

    @PostMapping(value = "/resultsmatches")
    public ModelAndView updateScore(@RequestParam String wrestlerName, @RequestParam String typeMatch){
        ModelAndView map = new ModelAndView("resultsmatches");
        scoreChangerService.changeScore(Integer.parseInt(typeMatch),wrestlerName);
        streakCounterService.streakCount(Integer.parseInt(typeMatch),wrestlerName);
        map.addObject("message",0);
        map.addObject("wrestlerList",wrestlerService.findAllAndOrder());
        return map;
    }


}
