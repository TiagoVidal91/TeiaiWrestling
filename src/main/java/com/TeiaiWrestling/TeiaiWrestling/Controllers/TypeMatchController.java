package com.TeiaiWrestling.TeiaiWrestling.Controllers;

import com.TeiaiWrestling.TeiaiWrestling.Services.TypeMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TypeMatchController {

    @Autowired
    TypeMatchService typeMatchService;

    @GetMapping(value = "/choosematch")
    public ModelAndView showMatchesPage() {
        ModelAndView map = new ModelAndView("choosematch");
        map.addObject("matchtypelist", typeMatchService.findAll());
        return map;
    }

    @PostMapping(value = "/choosematch")
    public ModelAndView showSingleMatchPage(String matchType){
        System.out.println(matchType);
        ModelAndView map = new ModelAndView("home");
        switch(matchType){
            case ("Single"):
                map= new ModelAndView("redirect:/singlematch");
        }
        return map;
    }
}
