package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.model.ProductDetail;
import com.ecommerce.service.dto.FullProductDTO;
import com.ecommerce.service.dto.GenericResponse;
import com.ecommerce.service.dto.ProductTablePageDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();

    Optional<Product> getById(Long id);

    Optional<ProductDetail> getDetailsById(Long id);

    GenericResponse deleteById(Long id);

    GenericResponse createProduct(FullProductDTO fullProductDTO);

    GenericResponse editProduct(Long id, FullProductDTO fullProductDTO);

    ProductTablePageDTO getPage(int page, int size, String order);
}
