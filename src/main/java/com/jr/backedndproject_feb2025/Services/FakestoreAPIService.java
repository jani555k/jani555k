package com.jr.backedndproject_feb2025.Services;

import com.jr.backedndproject_feb2025.Models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakestoreAPIService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public Product getProductByTitle(String title) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product replaceProduct(Product product) {
        return null;
    }
}
