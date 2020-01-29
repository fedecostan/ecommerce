package com.ecommerce.service;

import com.ecommerce.model.*;
import com.ecommerce.repository.ProductDetailRepository;
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

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<ProductDetail> getDetailsById(Long id) {
        return productDetailRepository.findByProductId(id);
    }

    @Override
    public GenericResponse createProduct(FullProductDTO fullProductDTO) {
        try {
            Product product = new Product(fullProductDTO);
            ProductDetail productDetail = new ProductDetail(fullProductDTO);
            productDetail.setProduct(product);
            ProductType productType = getProductType(fullProductDTO);
            productDetail.setProductType(productType);
            Screen screen = new Screen(fullProductDTO);
            Manufacturer manufacturer = new Manufacturer(fullProductDTO);
            if (productType.getId() == 1) {
                TvInfo tvInfo = new TvInfo(fullProductDTO);
                tvInfo.setScreen(screen);
                tvInfo.setManufacturer(manufacturer);
                productDetail.setTvInfo(tvInfo);
            } else if (productType.getId() == 2) {
                PhoneInfo phoneInfo = new PhoneInfo(fullProductDTO);
                phoneInfo.setScreen(screen);
                phoneInfo.setManufacturer(manufacturer);
                productDetail.setPhoneInfo(phoneInfo);
            } else if (productType.getId() == 3) {
                LaptopInfo laptopInfo = new LaptopInfo(fullProductDTO);
                laptopInfo.setScreen(screen);
                laptopInfo.setManufacturer(manufacturer);
                productDetail.setLaptopInfo(laptopInfo);
            }
            productDetailRepository.save(productDetail);
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
