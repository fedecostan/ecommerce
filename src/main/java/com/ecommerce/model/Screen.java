package com.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "SCREEN")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "INCHES")
    private Double inches;

    @Column(name = "TECHNOLOGY")
    private String technology;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "RESOLUTION")
    private String resolution;

    @Column(name = "REFRESH_RATE")
    private String refreshRate;

    @Column(name = "ADDITIONAL_INFO")
    private String additionalInfo;
}
