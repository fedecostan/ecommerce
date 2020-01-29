package com.ecommerce.model;

import com.ecommerce.service.dto.FullProductDTO;

import javax.persistence.*;

@Entity
@Table(name = "PHONE_INFO")
public class PhoneInfo {

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

    @Column(name = "OPERATING_SYSTEM")
    private String operatingSystem;

    @Column(name = "HARD_DRIVE_SIZE")
    private String hardDriveSize;

    @Column(name = "RAM_SIZE")
    private Integer ramSize;

    @Column(name = "BATTERY")
    private Integer battery;

    @Column(name = "BACK_CAMERA")
    private String backCamera;

    @Column(name = "FRONT_CAMERA")
    private String frontCamera;

    @Column(name = "SIM_TYPE")
    private String simType;

    @Column(name = "VIDEO_RECORDER")
    private String videoRecorder;

    @Column(name = "NFC_CAPABLE")
    private Boolean nfcCapable;

    public PhoneInfo() {
    }

    public PhoneInfo(FullProductDTO fullProductDTO) {
        this.operatingSystem = fullProductDTO.getOperatingSystem();
        this.hardDriveSize = fullProductDTO.getHardDriveSize();
        this.ramSize = fullProductDTO.getRamSize();
        this.battery = fullProductDTO.getBattery();
        this.backCamera = fullProductDTO.getBackCamera();
        this.frontCamera = fullProductDTO.getFrontCamera();
        this.simType = fullProductDTO.getSimType();
        this.videoRecorder = fullProductDTO.getVideoRecorder();
        this.nfcCapable = fullProductDTO.getNfcCapable();
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

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
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

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public String getBackCamera() {
        return backCamera;
    }

    public void setBackCamera(String backCamera) {
        this.backCamera = backCamera;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public String getVideoRecorder() {
        return videoRecorder;
    }

    public void setVideoRecorder(String videoRecorder) {
        this.videoRecorder = videoRecorder;
    }

    public Boolean getNfcCapable() {
        return nfcCapable;
    }

    public void setNfcCapable(Boolean nfcCapable) {
        this.nfcCapable = nfcCapable;
    }
}
