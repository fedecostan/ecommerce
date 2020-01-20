package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productController")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public @ResponseBody
    List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    Optional<Product> getById(@PathVariable Long id) {
        return productService.getById(id);
    }

}
