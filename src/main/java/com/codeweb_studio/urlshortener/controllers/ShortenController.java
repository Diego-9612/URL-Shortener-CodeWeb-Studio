package com.codeweb_studio.urlshortener.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
public class ShortenController {

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String url){
        log.info("URL: {}", url);
        return "index";
    }
}
