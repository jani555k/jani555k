package com.jr.backendproject_feb2025.Services;

import com.jr.backendproject_feb2025.DTOs.FakestoreProductDTO;
import com.jr.backendproject_feb2025.Models.Category;
import com.jr.backendproject_feb2025.Models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.jr.backendproject_feb2025.DTOs.FakestoreProductDTO.convertProductToFakestoreProduct;

@Service
public class FakestoreAPIService implements ProductService{

    private final RestTemplate restTemplate;

    public FakestoreAPIService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        FakestoreProductDTO fakestoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakestoreProductDTO.class);
        return Product.convertFakestoreProductToProduct(fakestoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        FakestoreProductDTO[] fakestoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products", FakestoreProductDTO[].class);

        List<Product> products = new ArrayList<>();
        for(FakestoreProductDTO fakestoreProductDTO1 : fakestoreProductDTO){
            products.add(Product.convertFakestoreProductToProduct(fakestoreProductDTO1));
        }

        return products;
    }

    @Override
    public Product addProduct(Product product) {
        FakestoreProductDTO fakestoreProductDTO = convertProductToFakestoreProduct(product);

        FakestoreProductDTO response = restTemplate.postForObject(
                "https://fakestoreapi.com/products", fakestoreProductDTO, FakestoreProductDTO.class);

        return Product.convertFakestoreProductToProduct(response);

    }

    @Override
    public Product updateProduct(Long id, Product product) {
        FakestoreProductDTO fakestoreProductDTO = FakestoreProductDTO.convertProductToFakestoreProduct(product);

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakestoreProductDTO, FakestoreProductDTO.class);
        HttpMessageConverterExtractor<FakestoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakestoreProductDTO.class, restTemplate.getMessageConverters());
        FakestoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PATCH, requestCallback, responseExtractor);

        return Product.convertFakestoreProductToProduct(response);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        FakestoreProductDTO fakestoreProductDTO = FakestoreProductDTO.convertProductToFakestoreProduct(product);

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakestoreProductDTO, FakestoreProductDTO.class);
        HttpMessageConverterExtractor<FakestoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakestoreProductDTO.class, restTemplate.getMessageConverters());
        FakestoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return Product.convertFakestoreProductToProduct(response);

    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
    }
}
