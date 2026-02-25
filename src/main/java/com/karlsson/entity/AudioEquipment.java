package com.karlsson.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "audio_equipment")
public class AudioEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category", nullable = false,  length = 50)
    private String category;

    @Column(name = "brand", nullable = false,  length = 50)
    private String brand;

    @Column(name = "model", nullable = false,  length = 50)
    private String model;

    @Column(name = "price_per_day", nullable = false)
    private double pricePerDay;


    protected AudioEquipment() {}

    public AudioEquipment(Long id, String name, String category, String brand, String model, double pricePerDay) {
        this.id = id;
        this.category = category;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public Long getId() {
        return id;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
