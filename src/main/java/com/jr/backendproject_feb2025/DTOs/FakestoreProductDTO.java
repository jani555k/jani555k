package com.jr.backendproject_feb2025.DTOs;

import com.jr.backendproject_feb2025.Models.Product;
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

    public static FakestoreProductDTO convertProductToFakestoreProduct(Product product){
        FakestoreProductDTO fakestoreProductDTO = new FakestoreProductDTO();
        fakestoreProductDTO.setId(product.getId());
        fakestoreProductDTO.setDescription(product.getDescription());
        fakestoreProductDTO.setPrice(product.getPrice());
        fakestoreProductDTO.setImage(product.getImage());
        fakestoreProductDTO.setTitle(product.getTitle());
        fakestoreProductDTO.setCategory(product.getCategory().getTitle());

        return fakestoreProductDTO;

    }
}
