package com.codeweb_studio.urlshortener.repository;

import com.codeweb_studio.urlshortener.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {

    Optional<ResourceEntity> findByShortUrl(String shortUrl);
}
