package com.codeweb_studio.urlshortener.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ClickStatistics {
    private Long resourceId;
    private Long clickCount;
}
