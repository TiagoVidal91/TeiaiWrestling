package com.TeiaiWrestling.TeiaiWrestling.Controllers;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Match;
import com.TeiaiWrestling.TeiaiWrestling.Services.TypeMatchService;
import com.TeiaiWrestling.TeiaiWrestling.Services.WrestlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MatchController {

    @Autowired
    TypeMatchService typeMatchService;

    @Autowired
    WrestlerService wrestlerService;

    @GetMapping(value = "/matchesinput")
    public ModelAndView showMatchesPage(){
        ModelAndView map = new ModelAndView("matchesinput");
        map.addObject("matchtypelist",typeMatchService.findAll());
        map.addObject("wrestlernames",wrestlerService.findAllAndOrder());
        return map;
    }

//    @PostMapping(value = "/matchesinput")
//    public ModelAndView updateMatch(@RequestParam String typeMatch, List<String> victory,
//                                    List<String> loss, List<String> noWin, List<String> draw){
//        Match match1 = new Match();
//
//        match1.setVictory(victory);
//
//        for(String matches: match1.getVictory()){
//            System.out.println(matches);
//        }
//
//    }


}
