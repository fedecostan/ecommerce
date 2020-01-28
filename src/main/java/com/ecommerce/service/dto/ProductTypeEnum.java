package com.ecommerce.service.dto;

public enum ProductTypeEnum {
    TV_INFO("TV", 1L),
    PHONE_INFO("PHONE", 2L),
    LAPTOP_INFO("LAPTOP", 3L);

    private String productType;
    private Long productTypeId;

    ProductTypeEnum(String productType, Long productTypeId) {
        this.productType = productType;
        this.productTypeId = productTypeId;
    }

    public String getProductType() {
        return productType;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

}
