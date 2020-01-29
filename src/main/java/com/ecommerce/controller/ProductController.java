package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.model.ProductDetail;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.dto.FullProductDTO;
import com.ecommerce.service.dto.GenericResponse;
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

    @GetMapping(value = "/details/{id}")
    public @ResponseBody
    Optional<ProductDetail> getDetailsById(@PathVariable Long id) {
        return productService.getDetailsById(id);
    }

    @GetMapping(value = "/delete/{id}")
    public @ResponseBody
    GenericResponse deleteById(@PathVariable Long id) {
        return productService.deleteById(id);
    }

    @PostMapping(value = "/newProduct")
    public GenericResponse newProduct(@RequestBody FullProductDTO fullProductDTO) {
        return productService.createProduct(fullProductDTO);
    }

    @PostMapping(value = "/editProduct/{id}")
    public GenericResponse editProduct(@PathVariable Long id, @RequestBody FullProductDTO fullProductDTO) {
        return productService.editProduct(id, fullProductDTO);
    }

}
