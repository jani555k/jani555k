package com.jr.backedndproject_feb2025.Services;

import com.jr.backedndproject_feb2025.Models.Product;

import java.util.List;

public interface ProductService {
 Product getProductById(Long id);

 Product getProductByTitle(String title);

 List<Product> getAllProducts();

 Product addProduct(Product product);

 Product updateProduct(Product product);

 void deleteProduct(Long id);

 Product replaceProduct(Product product);

}
