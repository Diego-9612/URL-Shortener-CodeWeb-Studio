package com.codeweb_studio.urlshortener.services;

import com.codeweb_studio.urlshortener.entity.ResourceEntity;
import com.codeweb_studio.urlshortener.exception.CodeNotFoundException;
import com.codeweb_studio.urlshortener.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ResourceResolver {

    private final ResourceRepository resourceRepository;

    public ResourceEntity resolveShortCode(String shortCode){
        return resourceRepository.findByShortUrl(shortCode)
                .orElseThrow(() -> new CodeNotFoundException(shortCode));
    }
}
