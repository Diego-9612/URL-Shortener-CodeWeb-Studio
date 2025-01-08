package com.codeweb_studio.urlshortener.controllers;

import com.codeweb_studio.urlshortener.services.ShortCodeGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RootController {

    private final ShortCodeGenerator generator;

    @RequestMapping
    public String index(){
        log.info("Code: {}", generator.generateShortCode());
        return "index";
    }
}
