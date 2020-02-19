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

    public Screen(FullProductDTO fullProductDTO) {
        this.inches = fullProductDTO.getScreenInches();
        this.technology = fullProductDTO.getScreenTechnology();
        this.type = fullProductDTO.getScreenType();
        this.resolution = fullProductDTO.getScreenResolution();
        this.refreshRate = fullProductDTO.getScreenRefreshRate();
        this.additionalInfo = fullProductDTO.getScreenAdditionalInfo();
    }

}
