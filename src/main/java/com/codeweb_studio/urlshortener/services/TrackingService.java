package com.codeweb_studio.urlshortener.services;

import com.codeweb_studio.urlshortener.entity.ResourceEntity;
import com.codeweb_studio.urlshortener.entity.TrackingEntity;
import com.codeweb_studio.urlshortener.repository.TrackingRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackingService {

    private final TrackingRepository trackingRepository;

    public TrackingEntity trackClick(ResourceEntity resourceEntity, HttpServletRequest request){

        var entity = TrackingEntity.builder()
                .resourceId(resourceEntity.getId())
                .userAgent(request.getHeader(HttpHeaders.USER_AGENT))
                .ip(request.getHeader("X-Original-IP"))
                .referer(request.getHeader(HttpHeaders.REFERER))
                .build();
        return trackingRepository.save(entity);
    }
}
