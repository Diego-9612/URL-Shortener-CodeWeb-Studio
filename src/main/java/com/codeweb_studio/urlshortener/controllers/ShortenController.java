package com.codeweb_studio.urlshortener.controllers;

import com.codeweb_studio.urlshortener.services.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Slf4j
@Controller
@RequiredArgsConstructor
public class ShortenController {

    private final UrlShortenerService urlShortener;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String url, Model model){
        log.info("Shortening URL: {}", url);
        var resource =urlShortener.shorten(url);
        model.addAttribute("shortUrl", resource.getShortUrl());
        return "index";
    }
}
