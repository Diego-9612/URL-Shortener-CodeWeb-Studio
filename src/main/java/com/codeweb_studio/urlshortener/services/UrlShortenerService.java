package com.codeweb_studio.urlshortener.services;

import com.codeweb_studio.urlshortener.entity.ResourceEntity;
import com.codeweb_studio.urlshortener.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlShortenerService {

    private final ShortCodeGenerator shortCodeGenerator;
    private final ResourceRepository resourceRepository;

    public ResourceEntity shorten(@URL String originalUrl){
        var entity = ResourceEntity.builder()
                .type(ResourceEntity.Type.URL)
                .originalUrl(originalUrl)
                .shortUrl(shortCodeGenerator.generateShortCode())
                .build();

        return resourceRepository.save(entity);
    }
}
