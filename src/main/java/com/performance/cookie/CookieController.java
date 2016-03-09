package com.performance.cookie;

import com.performance.domain.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CookieController {

    private final CookieService cookieService;

    @Autowired
    public CookieController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @RequestMapping(value = "/cookies", method = RequestMethod.GET)
    public List<Cookie> getCookies() {
        return cookieService.getCookies();
    }
}