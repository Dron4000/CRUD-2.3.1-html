package com.javaspringclub.controller;

import java.util.List;

import com.javaspringclub.entity.Product;
import com.javaspringclub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    ProductService productService;

    public AppController() {
    }

    @Autowired
    public AppController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<?> listProducts = productService.getAllProducts();
        model.addAttribute("listProducts", listProducts);
        return "home";
    }

    @GetMapping(value = "/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @PostMapping(value = "/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);

        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditProductPage(@PathVariable(name = "id") int id,Model model) {
        Product product = productService.getProductById((long) id);
        model.addAttribute("product",product);
        return "edit_product";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productService.deleteProductById((long) id);
        return "redirect:/";
    }
    @GetMapping(value = "/403")
    String show403(){
        return "403";
    }





}
