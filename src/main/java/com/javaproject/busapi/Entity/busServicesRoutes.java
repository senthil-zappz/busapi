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
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "busservices")
public class busServicesRoutes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "serviceno", nullable = false)
    public String serviceno;
    @Column(name = "operator", nullable = false)
    public String operator;
    @Column(name = "direction", nullable = false)
    public int direction;
    @Column(name = "category", nullable = false)
    public String category;
    @Column(name = "origincode", nullable = false)
    public String origincode;
    @Column(name = "destinationcode", nullable = false)
    public String destinationcode;
    @Column(name = "am_peak_freq", nullable = false)
    public String am_peak_freq;
    @Column(name = "am_offpeak_freq", nullable = false)
    public String am_offpeak_freq;
    @Column(name = "pm_peak_freq", nullable = false)
    public String pm_peak_freq;
    @Column(name = "pm_offpeak_freq", nullable = false)
    public String pm_offpeak_freq;
    @Column(name = "loopdesc", nullable = false)
    public String loopdesc;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

}
