package com.codeweb_studio.urlshortener.services;

import com.codeweb_studio.urlshortener.entity.ResourceEntity;
import com.codeweb_studio.urlshortener.entity.TrackingEntity;
import com.codeweb_studio.urlshortener.repository.TrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackingService {

    private final TrackingRepository trackingRepository;

    public TrackingEntity trackClick(ResourceEntity resourceEntity){

        var entity = TrackingEntity.builder()
                .resourceId(resourceEntity.getId())
                .build();
        return trackingRepository.save(entity);
    }
}
