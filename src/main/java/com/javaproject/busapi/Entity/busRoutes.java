package com.javaproject.busapi.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "busroutes")
public class busRoutes implements Serializable {

    
    @Column(name = "serviceno", nullable = false)
    public String serviceno;
    @Column(name = "operator", nullable = false)
    public String operator;
    @Column(name = "direction", nullable = false)
    public int direction;
    @Column(name = "stopsequence", nullable = false)
    public int stopsequence;
    @Column(name = "busstopcode", nullable = false)
    public String busstopcode;
    @Column(name = "distance", nullable = false)
    public double distance;
    @Column(name = "wd_firstbus", nullable = false)
    public String wd_firstbus;
    @Column(name = "wd_lastbus", nullable = false)
    public String wd_lastbus;
    @Column(name = "sat_firstbus", nullable = false)
    public String sat_firstbus;
    @Column(name = "sat_lastbus", nullable = false)
    public String sat_lastbus;
    @Column(name = "sun_firstbus", nullable = false)
    public String sun_firstbus;
    @Column(name = "sun_lastbus", nullable = false)
    public String sun_lastbus;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "busstopcode", referencedColumnName = "busstopcode")
    private Set<busStopsRoutes> busStopsRoutes = new HashSet<>();

}
