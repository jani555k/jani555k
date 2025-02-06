package com.jr.backendproject_feb2025.Controllers;

import com.jr.backendproject_feb2025.Models.Product;
import com.jr.backendproject_feb2025.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product addProduct(Product product){
        return productService.addProduct(product);
    }

    @PatchMapping()
    public Product updateProduct(Product product){
        return productService.updateProduct(product);
    }

    @PutMapping()
    public Product replaceProduct(Product product){
        return productService.replaceProduct(product);
    }

    @DeleteMapping()
    public void deleteProduct(Long id){
        productService.deleteProduct(id);
    }

}
