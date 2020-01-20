package com.ecommerce.service;

import com.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();

    Optional<Product> getById(Long id);

}
