package com.javaproject.busapi.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
@Table(name = "busstops")
public class busStops {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @Pattern(regexp = "[0-9]")
    private String busstopcode;

    @Column(nullable = false)
    private String roadname;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    public busStops() {

    }

    @Builder
    public busStops(String busstopcode, String roadname, String description, String latitude, String longitude) {
        this.busstopcode = busstopcode;
        this.roadname = roadname;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
