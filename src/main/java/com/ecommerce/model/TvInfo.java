package com.ecommerce.model;

import com.ecommerce.service.dto.FullProductDTO;

import javax.persistence.*;

@Entity
@Table(name = "TV_INFO")
public class TvInfo {

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

    @Column(name = "SMART_TV")
    private Boolean smartTv;

    @Column(name = "YEAR")
    private Integer year;

    public TvInfo() {
    }

    public TvInfo(FullProductDTO fullProductDTO) {
        this.smartTv = fullProductDTO.getSmartTv();
        this.year = fullProductDTO.getYear();
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

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
