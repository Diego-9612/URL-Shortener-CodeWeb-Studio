package com.codeweb_studio.urlshortener.models;

import com.codeweb_studio.urlshortener.entity.ResourceEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResourceListItem {
    private ResourceEntity resource;
    private ClickStatistics clickStatistics;
}
