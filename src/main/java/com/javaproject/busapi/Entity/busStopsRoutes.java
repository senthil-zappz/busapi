package com.javaproject.busapi.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "busstops")
public class busStopsRoutes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "busstopcode", nullable = false)
    public String busstopcode;

    @Column(name = "roadname", nullable = false)
    public String raoadname;

    @Column(name = "description", nullable = false)
    public String description;

    @Column(name = "latitude", nullable = false)
    public double latitude;

    @Column(name = "longitude", nullable = false)
    public double longitude;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

}
