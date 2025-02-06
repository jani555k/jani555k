package com.jr.backendproject_feb2025.Services;

import com.jr.backendproject_feb2025.DTOs.FakestoreProductDTO;
import com.jr.backendproject_feb2025.Models.Category;
import com.jr.backendproject_feb2025.Models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakestoreAPIService implements ProductService{

    private final RestTemplate restTemplate;

    public FakestoreAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakestoreProductDTO fakestoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakestoreProductDTO.class);
        return ConvertFakestoreProductToProduct(fakestoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        FakestoreProductDTO[] fakestoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products", FakestoreProductDTO[].class);

        List<Product> products = new ArrayList<>();
        for(FakestoreProductDTO fakestoreProductDTO1 : fakestoreProductDTO){
            products.add(ConvertFakestoreProductToProduct(fakestoreProductDTO1));
        }

        return products;
    }

    @Override
    public Product addProduct(Product product) {

        return restTemplate.postForObject("https://fakestoreapi.com/products", product, Product.class);
    }

    @Override
    public Product updateProduct(Product product) {

        return restTemplate.patchForObject("https://fakestoreapi.com/products/" + product.getId(), product, Product.class);
    }

    @Override
    public Product replaceProduct(Product product) {

        return new Product();
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }

    private Product ConvertFakestoreProductToProduct(FakestoreProductDTO fakestoreProductDTO) {
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
