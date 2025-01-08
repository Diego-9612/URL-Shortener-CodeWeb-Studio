package com.codeweb_studio.urlshortener.controllers;

import com.codeweb_studio.urlshortener.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/list")
public class ResourceListController {

    private final ResourceRepository resourceRepository;

    @GetMapping
    public String listResources(Model model){
        var resources = resourceRepository.findAll();
        model.addAttribute("resources", resources);
        return "list";
    }
}
