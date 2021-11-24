package com.javaspringclub.controller;

import java.util.List;

import com.javaspringclub.entity.Product;
import com.javaspringclub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    ProductService productService;

    public AppController() {
    }

    @Autowired
    public AppController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<?> listProducts = productService.getAllProducts();
        model.addAttribute("listProducts", listProducts);
        return "home";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @PostMapping (value = "/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);

        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}",method ={ RequestMethod.GET, RequestMethod.POST })
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = productService.getProductById((long) id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping(value = "/delete/{id}",method = {RequestMethod.GET,RequestMethod.POST})
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productService.deleteProductById((long) id);
        return "redirect:/";
    }


}
