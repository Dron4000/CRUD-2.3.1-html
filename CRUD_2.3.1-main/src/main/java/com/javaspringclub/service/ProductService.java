package com.javaspringclub.service;

import com.javaspringclub.entity.Product;

import java.util.List;

public interface ProductService {

    public List getAllProducts();

    public Product getProductById(Long id);

    public void saveProduct(Product product);

    public void deleteProductById(Long id);
}