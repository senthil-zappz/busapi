package com.javaproject.busapi.Files;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="busservices")
public class busServices {
  
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private long id;

  @Column(nullable = false)
  private String serviceno;
  @Column(nullable = false)
  private String operator;
  @Column(nullable = false)
  private int direction;
  @Column(nullable = false)
  private String category;
  @Column(nullable = false)
  private String origincode;
  @Column(nullable = false)
  private String destinationcode;
  @Column(nullable = false)
  private String am_peak_freq;
  @Column(nullable = false)
  private String pm_peak_freq;
  @Column(nullable = false)
  private String pm_offpeak_freq;
  @Column(nullable = false)
  private String loopdesc;
  
  //   public busServices() {
  //   this.id = UUID.randomUUID().toString();
  // } //when this line is instantiated, the code will run.
    @Builder
  public busServices(String serviceno,String operator,int direction, String category, String origincode, String destinationcode, String am_offpeak_freq ,String am_peak_freq, String pm_peak_frequency, String pm_offpeak_frequency,String loopdesc) {
    this.serviceno = serviceno;
    this.operator=operator;
    this.direction=direction;
    this.category=category;
    this.origincode=origincode;
    this.destinationcode=destinationcode;
    this.am_peak_freq=am_peak_freq;
    // this.am_offpeak_freq=am_offpeak_freq;
    // this.pm_peak_freq=pm_peak_freq;
    // this.pm_offpeak_freq=pm_offpeak_freq;
    // this.loopdesc=loopdesc;
}

}
