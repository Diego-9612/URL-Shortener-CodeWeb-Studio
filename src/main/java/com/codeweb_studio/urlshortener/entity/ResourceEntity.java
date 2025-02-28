package com.codeweb_studio.urlshortener.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resources")
public class ResourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    private String shortUrl;

    private String originalUrl;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        URL;
    }

}
