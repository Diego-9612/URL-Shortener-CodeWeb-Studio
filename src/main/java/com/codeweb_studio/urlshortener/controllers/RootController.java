package com.codeweb_studio.urlshortener.controllers;

import com.codeweb_studio.urlshortener.services.ResourceResolver;
import com.codeweb_studio.urlshortener.services.ShortCodeGenerator;
import com.codeweb_studio.urlshortener.services.TrackingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RootController {

    private final ShortCodeGenerator generator;
    private final ResourceResolver resolver;
    private final TrackingService trackingService;

    @RequestMapping
    public String index() {
        log.info("Code: {}", generator.generateShortCode());
        return "index";
    }

    @GetMapping("/{shortCode}")
    public RedirectView resolve(@PathVariable String shortCode) {
        var resource = resolver.resolveShortCode(shortCode);
        trackingService.trackClick(resource);
        return new RedirectView(resource.getOriginalUrl());
    }
}

