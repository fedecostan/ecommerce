package com.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_DETAIL")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @JoinColumn(name = "PRODUCT_ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;

    @JoinColumn(name = "PRODUCT_TYPE_ID")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductType productType;

    @JoinColumn(name = "TV_INFO_ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TvInfo tvInfo;

    @JoinColumn(name = "PHONE_INFO_ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PhoneInfo phoneInfo;

    @JoinColumn(name = "LAPTOP_INFO_ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private LaptopInfo laptopInfo;

    public ProductDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public TvInfo getTvInfo() {
        return tvInfo;
    }

    public void setTvInfo(TvInfo tvInfo) {
        this.tvInfo = tvInfo;
    }

    public PhoneInfo getPhoneInfo() {
        return phoneInfo;
    }

    public void setPhoneInfo(PhoneInfo phoneInfo) {
        this.phoneInfo = phoneInfo;
    }

    public LaptopInfo getLaptopInfo() {
        return laptopInfo;
    }

    public void setLaptopInfo(LaptopInfo laptopInfo) {
        this.laptopInfo = laptopInfo;
    }

}
