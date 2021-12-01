package com.TeiaiWrestling.TeiaiWrestling.Controllers;

import com.TeiaiWrestling.TeiaiWrestling.Services.AverageMatchService;
import com.TeiaiWrestling.TeiaiWrestling.Services.ScoreChangerService;
import com.TeiaiWrestling.TeiaiWrestling.Services.StreakCounterService;
import com.TeiaiWrestling.TeiaiWrestling.Services.WrestlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ModelAndView updateScore(@RequestBody String wrestler){
        ModelAndView map = new ModelAndView("resultsmatches");
        String matchTypeStr = wrestler.substring("typeMatch=".length()).split("&")[0];
        String wrestlersNames = wrestler.substring(("typeMatch="+matchTypeStr).length()).
                replaceAll("wrestlerName=","")
                .replaceAll("\\+"," ");
        System.out.println(matchTypeStr);
        System.out.println(wrestlersNames);
        if(!wrestlersNames.isEmpty()) {
            for (int i = 1; i < wrestlersNames.split("&").length; i++) {
                scoreChangerService.changeScore(Integer.parseInt(matchTypeStr), wrestlersNames.split("&")[i]);
                streakCounterService.streakCount(Integer.parseInt(matchTypeStr), wrestlersNames.split("&")[i]);
                map.addObject("message",0);
            }
        }else{
            map.addObject("message",1);
        }
        map.addObject("wrestlerList",wrestlerService.findAllAndOrder());
        return map;
    }


}
