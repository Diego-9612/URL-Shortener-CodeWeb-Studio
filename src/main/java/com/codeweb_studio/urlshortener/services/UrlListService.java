package com.codeweb_studio.urlshortener.services;

import com.codeweb_studio.urlshortener.entity.ResourceEntity;
import com.codeweb_studio.urlshortener.models.ClickStatistics;
import com.codeweb_studio.urlshortener.models.ResourceListItem;
import com.codeweb_studio.urlshortener.repository.ResourceRepository;
import com.codeweb_studio.urlshortener.repository.TrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UrlListService {

    private final ResourceRepository resourceRepository;
    private final TrackingRepository trackingRepository;

    public List<ResourceListItem> getResources() {
        var resources = resourceRepository.findAll();
        var resourcesIds = resources.stream()
                .map(ResourceEntity::getId)
                .collect(Collectors.toSet());
        var clickStatistics = trackingRepository.findClickStatistics(resourcesIds).stream()
                .collect(Collectors.toMap(ClickStatistics::getResourceId, Function.identity()));

        return resources.stream()
                .map(resource -> {
                    var stats = clickStatistics.getOrDefault(resource.getId(),
                            ClickStatistics.builder()
                                    .resourceId(resource.getId())
                                    .clickCount(0L)
                                    .build()
                    );
                    return ResourceListItem.builder()
                            .resource(resource)
                            .clickStatistics(stats)
                            .build();
                })
                .collect(Collectors.toList());
    }
}
