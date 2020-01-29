package com.ecommerce.model;

import com.ecommerce.service.dto.FullProductDTO;

import javax.persistence.*;

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

    @Column(name = "SIZE")
    private String size;

    @Column(name = "WEIGHT")
    private Integer weight;

    public LaptopInfo() {
    }

    public LaptopInfo(FullProductDTO fullProductDTO) {
        this.processor = fullProductDTO.getProcessor();
        this.hardDriveSize = fullProductDTO.getHardDriveSize();
        this.ramSize = fullProductDTO.getRamSize();
        this.graphics = fullProductDTO.getGraphics();
        this.camera = fullProductDTO.getFrontCamera();
        this.operatingSystem = fullProductDTO.getOperatingSystem();
        this.size = fullProductDTO.getSize();
        this.weight = fullProductDTO.getWeight();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getHardDriveSize() {
        return hardDriveSize;
    }

    public void setHardDriveSize(String hardDriveSize) {
        this.hardDriveSize = hardDriveSize;
    }

    public Integer getRamSize() {
        return ramSize;
    }

    public void setRamSize(Integer ramSize) {
        this.ramSize = ramSize;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
