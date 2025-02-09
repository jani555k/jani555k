package com.jr.backendproject_feb2025.Models;

import com.jr.backendproject_feb2025.DTOs.FakestoreProductDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private double price;
    private Category category;
    private String description;
    private String image;

    public static Product convertFakestoreProductToProduct(FakestoreProductDTO fakestoreProductDTO) {
        Product product = new Product();

        product.setId(fakestoreProductDTO.getId());
        product.setTitle(fakestoreProductDTO.getTitle());
        product.setDescription(fakestoreProductDTO.getDescription());
        product.setPrice(fakestoreProductDTO.getPrice());

        Category category = new Category();
        category.setTitle(fakestoreProductDTO.getCategory());
        product.setCategory(category);

        return product;

    }

}
