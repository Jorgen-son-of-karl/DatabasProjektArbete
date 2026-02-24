package com.wigell.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instruments")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" ,nullable = false, length = 50)
    private String name;

    @Column(name = "type", nullable = false , length = 50)
    private String type; // Guitar, Piano, Drums...

    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @Column(name="price_per_day", nullable = false)
    private double pricePerDay;

    protected Instrument() {}

    public Instrument(String name, String type, String brand, double pricePerDay) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getType() { return type; }

    public String getBrand() { return brand; }

    public double getPricePerDay() { return pricePerDay; }
}