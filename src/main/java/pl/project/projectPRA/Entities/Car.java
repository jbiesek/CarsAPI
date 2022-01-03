package pl.project.projectPRA.Entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "Car")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property="refId", scope=Car.class)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String vin;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;


    public Car(String vin, String brand, String model, Integer year, Dealer dealer) {
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.dealer = dealer;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Car() {
    }
}
