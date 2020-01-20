package com.ecommerce.model;

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
    private Integer hardDriveSize;

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

}
