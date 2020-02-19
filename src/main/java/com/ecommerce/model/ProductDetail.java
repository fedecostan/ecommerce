package com.ecommerce.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
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

}
