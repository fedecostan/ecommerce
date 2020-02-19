package com.ecommerce.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_IMAGE")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @JoinColumn(name = "PRODUCT_ID")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;

    @Column(name = "URL")
    private String url;

}
