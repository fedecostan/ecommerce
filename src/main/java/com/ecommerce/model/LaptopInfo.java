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
@Table(name = "LAPTOP_INFO")
public class LaptopInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @JoinColumn(name = "SCREEN_ID")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Screen.class, cascade = CascadeType.ALL)
    private Screen screen;

    @JoinColumn(name = "MANUFACTURER_ID")
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Manufacturer.class, cascade = CascadeType.ALL)
    private Manufacturer manufacturer;

    @Column(name = "PROCESSOR")
    private String processor;

    @Column(name = "HARD_DRIVE_SIZE")
    private String hardDriveSize;

    @Column(name = "RAM_SIZE")
    private Integer ramSize;

    @Column(name = "GRAPHICS")
    private String graphics;

    @Column(name = "CAMERA")
    private String camera;

    @Column(name = "OPERATING_SYSTEM")
    private String operatingSystem;

    public LaptopInfo(FullProductDTO fullProductDTO) {
        this.processor = fullProductDTO.getProcessor();
        this.hardDriveSize = fullProductDTO.getHardDriveSize();
        this.ramSize = fullProductDTO.getRamSize();
        this.graphics = fullProductDTO.getGraphics();
        this.camera = fullProductDTO.getFrontCamera();
        this.operatingSystem = fullProductDTO.getOperatingSystem();
    }

}
