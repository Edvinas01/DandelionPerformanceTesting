package com.performance.cookie;

import com.performance.domain.Cookie;
import com.performance.domain.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Service
public class CookieService {

    public static final int COOKIE_COUNT = 100;

    public static final String[] TYPES = {
            "chocolate chip",
            "generic",
            "vanilla ice cream",
            "vanilla",
            "with raisins"
    };

    private final CookieRepository cookieRepository;
    private final Random random;

    @Autowired
    public CookieService(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
        this.random = new Random(System.nanoTime());
    }

    @PostConstruct
    public void init() {
        for (int i = 0; i < COOKIE_COUNT; i++) {
            cookieRepository.save(new Cookie(TYPES[random.nextInt(TYPES.length)], random.nextInt(COOKIE_COUNT)));
        }
    }

    public List<Cookie> getCookies() {
        return cookieRepository.findAll();
    }
}