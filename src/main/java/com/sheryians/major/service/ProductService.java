package com.sheryians.major.service;

import com.sheryians.major.model.Product;
import com.sheryians.major.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    public void addProduct(Product product){
        productRepository.save(product);
    }
    public void removeProductById(long id){
        productRepository.deleteById(id);
    }
    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }
    public List<Product> getAllProductsByCategoryId(int id){
        return productRepository.findAllByCategory_Id(id);
    }
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
//
public List<Product> getProductsByCategory(Integer categoryId) {
    return productRepository.findAllByCategory_Id(categoryId);
}

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

//
}
