package com.javaspringclub.service;

import com.javaspringclub.entity.Product;
import com.javaspringclub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;

    public ProductServiceImpl() {
    }


    @Override
    public List getAllProducts() {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }


    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
