package com.karlsson.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "audio_equipment")
public class AudioEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audio_equip_id")
    private Long audioEquipmentId;


    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false,  length = 50)
    private Category category;

    @Column(name = "brand", nullable = false,  length = 50)
    private String brand;

    @Column(name = "model", nullable = false,  length = 50)
    private String model;

    @Column(name = "price_per_day", nullable = false)
    private double pricePerDay;


    protected AudioEquipment() {}

    public AudioEquipment(Category category, String brand, String model, double pricePerDay) {
        this.category = category;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }
    
    public enum Category {
        AMPLIFIER ("Amplifier"),
        SPEAKER ("Speaker"),
        MIXING_TABLE("Mixing table");

        private final String value;

        Category(String value) {
            this.value = value;
        }
    }

    public Long getId() {
        return audioEquipmentId;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
