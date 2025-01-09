package com.codeweb_studio.urlshortener.repository;

import com.codeweb_studio.urlshortener.entity.TrackingEntity;
import com.codeweb_studio.urlshortener.models.ClickStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.List;

@Repository
public interface TrackingRepository extends JpaRepository<TrackingEntity, Long> {

    @Query(value = """
             SELECT resource_id, count(1) clickCount FROM tracking WHERE resource_id in (:resourceIds) GROUP BY resource_id;
             """, nativeQuery = true)
    List<ClickStatistics> findClickStatistics(Set<Long> resourceIds);
}
