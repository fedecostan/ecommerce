package com.ecommerce.model;

import com.ecommerce.service.dto.FullProductDTO;

import javax.persistence.*;

@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "CODE")
    private String code;

    public Manufacturer() {
    }

    public Manufacturer(FullProductDTO fullProductDTO) {
        this.name = fullProductDTO.getManufacturerName();
        this.model = fullProductDTO.getManufacturerModel();
        this.code = fullProductDTO.getManufacturerCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
