package com.jr.backendproject_feb2025.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakestoreProductDTO {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
