package com.ecommerce.model;

import com.ecommerce.service.dto.FullProductDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CODE")
    private String code;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "DISCOUNT")
    private Double discount;

    @Column(name = "STOCK")
    private Integer stock;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "SIZE")
    private String size;

    @Column(name = "WEIGHT")
    private Integer weight;

    public Product(FullProductDTO fullProductDTO) {
        this.code = fullProductDTO.getCode();
        this.price = fullProductDTO.getPrice();
        this.discount = fullProductDTO.getDiscount();
        this.stock = fullProductDTO.getStock();
        this.name = fullProductDTO.getName();
        this.description = fullProductDTO.getDescription();
        this.year = fullProductDTO.getYear();
        this.size = fullProductDTO.getSize();
        this.weight = fullProductDTO.getWeight();
    }

}
