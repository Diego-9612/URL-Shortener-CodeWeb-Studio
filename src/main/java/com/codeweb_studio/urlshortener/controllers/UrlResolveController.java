package com.codeweb_studio.urlshortener.controllers;

import com.codeweb_studio.urlshortener.services.ResourceResolver;
import com.codeweb_studio.urlshortener.services.TrackingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UrlResolveController {
    private final ResourceResolver resolver;
    private final TrackingService trackingService;

    @GetMapping("/{shortCode}")
    public RedirectView resolve(@PathVariable String shortCode, HttpServletRequest request) {
        var resource = resolver.resolveShortCode(shortCode);
        trackingService.trackClick(resource, request);
        return new RedirectView(resource.getOriginalUrl());
    }
}
