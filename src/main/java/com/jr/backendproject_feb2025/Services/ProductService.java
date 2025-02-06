package com.jr.backendproject_feb2025.Services;

import com.jr.backendproject_feb2025.Models.Product;

import java.util.List;

public interface ProductService {
 Product getProductById(Long id);

 List<Product> getAllProducts();

 Product addProduct(Product product);

 Product updateProduct(Product product);

 void deleteProduct(Long id);

 Product replaceProduct(Product product);

}
