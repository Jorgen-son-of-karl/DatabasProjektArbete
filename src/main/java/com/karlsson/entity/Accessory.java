package com.karlsson.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accessory")
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accessory_id")
    private int accessoryId;

    @Enumerated(EnumType.STRING)
    @Column(name = "accessory_type")
    private AccessoryType accessoryType;

    @Column(name = "brand", length = 50)
    private String brand;

    @Column(name ="model", length = 50)
    private String model;

    @Column(name = "price_per_day")
    private double pricePerDay;

    protected Accessory() {}

    public Accessory(AccessoryType accessoryType, String brand, String model, double pricePerDay) {
        this.accessoryType = accessoryType;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;

    }

    public enum AccessoryType {
        MIC_STAND ("Microphone stand"),
        CABLE_PACK ("Cable pack"),
        GUITAR_CASE ("Guitar case"),
        BASS_CASE ("Bass case");

        private final String value;
        AccessoryType(String value) {
            this.value = value;
        }

    }

}
