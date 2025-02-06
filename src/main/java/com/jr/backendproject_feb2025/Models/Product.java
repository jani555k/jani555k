package com.jr.backendproject_feb2025.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private double price;
    private Category category;
    private String description;
    private String image;

}
