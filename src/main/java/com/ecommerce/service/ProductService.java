package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.service.dto.FullProductDTO;
import com.ecommerce.service.dto.GenericResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();

    Optional<Product> getById(Long id);

    GenericResponse createProduct(FullProductDTO fullProductDTO);

    GenericResponse editProduct(Long id, FullProductDTO fullProductDTO);
}
