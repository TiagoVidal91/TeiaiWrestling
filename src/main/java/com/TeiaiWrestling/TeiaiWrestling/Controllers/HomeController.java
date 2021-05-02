package com.TeiaiWrestling.TeiaiWrestling.Controllers;

import com.TeiaiWrestling.TeiaiWrestling.Services.AverageMatchService;
import com.TeiaiWrestling.TeiaiWrestling.Services.MatchCountingService;
import com.TeiaiWrestling.TeiaiWrestling.Services.WrestlerService;
import com.TeiaiWrestling.TeiaiWrestling.Services.WrestlingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    WrestlerService wrestlerService;

    @Autowired
    WrestlingCardService wrestlingCardService;

    @Autowired
    MatchCountingService matchCountingService;

    @Autowired
    AverageMatchService averageMatchService;

    @GetMapping(value = "/")
    public ModelAndView showHomePage(){
        ModelAndView map = new ModelAndView("home");
        matchCountingService.returnMatchCount();
        averageMatchService.calculateAverage();
        map.addObject("wrestlerData", wrestlerService.findAllAndOrder());
        return map;
    }
}
