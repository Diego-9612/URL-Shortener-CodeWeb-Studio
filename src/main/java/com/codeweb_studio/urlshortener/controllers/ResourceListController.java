package com.codeweb_studio.urlshortener.controllers;

import com.codeweb_studio.urlshortener.repository.ResourceRepository;
import com.codeweb_studio.urlshortener.services.UrlListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/list")
public class ResourceListController {

    private final UrlListService urlListService;

    @GetMapping
    public String listResources(Model model){
        var resourceList = urlListService.getResources();
        model.addAttribute("resourceList", resourceList);
        return "list";
    }
}
