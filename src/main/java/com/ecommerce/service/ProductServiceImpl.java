package com.ecommerce.service;

import com.ecommerce.model.Product;
import com.ecommerce.model.ProductDetail;
import com.ecommerce.model.ProductType;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.ProductTypeRepository;
import com.ecommerce.service.dto.ErrorEnum;
import com.ecommerce.service.dto.FullProductDTO;
import com.ecommerce.service.dto.GenericResponse;
import com.ecommerce.service.dto.ProductTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public GenericResponse createProduct(FullProductDTO fullProductDTO) {
        try {
            Product product = new Product(fullProductDTO);
            ProductDetail productDetail = new ProductDetail(fullProductDTO);
            productDetail.setProductType(getProductType(fullProductDTO));
            //TODO: SET REST OF ENTITIES
            product.setProductDetail(productDetail);
            productRepository.save(product);
        } catch (Exception e) {
            return new GenericResponse(ErrorEnum.GENERIC_ERROR.getErrorMessage());
        }
        return new GenericResponse();
    }

    @Override
    public GenericResponse editProduct(Long id, FullProductDTO fullProductDTO) {
        Product product = productRepository.findById(id).orElse(null);
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setError(false);
        if (product == null) {
            genericResponse.setError(true);
            genericResponse.setErrorMessage("ERROR MSG");
        } else {
            updateProductInformation(product, fullProductDTO);
        }
        return genericResponse;
    }

    private ProductType getProductType(FullProductDTO fullProductDTO) {
        ProductTypeEnum productTypeEnum = null;
        if (ProductTypeEnum.TV_INFO.getProductType().equals(fullProductDTO.getType()))
            productTypeEnum = ProductTypeEnum.TV_INFO;
        if (ProductTypeEnum.PHONE_INFO.getProductType().equals(fullProductDTO.getType()))
            productTypeEnum = ProductTypeEnum.PHONE_INFO;
        if (ProductTypeEnum.LAPTOP_INFO.getProductType().equals(fullProductDTO.getType()))
            productTypeEnum = ProductTypeEnum.LAPTOP_INFO;
        return productTypeRepository.findById(productTypeEnum.getProductTypeId()).orElse(null);
    }

    private void updateProductInformation(Product product, FullProductDTO fullProductDTO) {
        //TODO: updateProductInformation
    }
}
