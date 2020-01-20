package com.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT_DETAIL")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @JoinColumn(name = "PRODUCT_ID")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Product.class, cascade = CascadeType.ALL)
    private Product product;

    @JoinColumn(name = "PRODUCT_TYPE_ID")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = ProductType.class, cascade = CascadeType.ALL)
    private ProductType productType;

    @JoinColumn(name = "TV_INFO_ID")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = TvInfo.class, cascade = CascadeType.ALL)
    private TvInfo tvInfo;

    @JoinColumn(name = "PHONE_INFO_ID")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = PhoneInfo.class, cascade = CascadeType.ALL)
    private PhoneInfo phoneInfo;

    @JoinColumn(name = "LAPTOP_INFO_ID")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = LaptopInfo.class, cascade = CascadeType.ALL)
    private LaptopInfo laptopInfo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

}
