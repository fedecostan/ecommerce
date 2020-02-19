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

    public Manufacturer(FullProductDTO fullProductDTO) {
        this.name = fullProductDTO.getManufacturerName();
        this.model = fullProductDTO.getManufacturerModel();
        this.code = fullProductDTO.getManufacturerCode();
    }

}
