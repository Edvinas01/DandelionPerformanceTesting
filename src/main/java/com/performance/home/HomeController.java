package com.performance.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/fast", method = RequestMethod.GET)
    public String fast() {
        return "home/fast";
    }

    @RequestMapping(value = "/slow", method = RequestMethod.GET)
    public String slow() {
        return "home/slow";
    }
}