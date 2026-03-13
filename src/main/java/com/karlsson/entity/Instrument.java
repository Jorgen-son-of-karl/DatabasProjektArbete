package com.karlsson.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instruments")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="instrument_id")
    private Long instrumentId;

    @Column(name = "name" ,nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false , length = 50)
    private Type type; //type of instrument

    @Column(name = "brand", nullable = false, length = 50)
    private String brand;

    @Column(name="price_per_day", nullable = false)
    private double pricePerDay;

    public Instrument(String name, Type type, String brand, double pricePerDay) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
    }

    protected Instrument() {}


    public enum Type{
        GUITAR ("Guitar"),
        BASS ("Bass"),
        KEYBOARD ("Keyboard");

        private final String value;

        Type(String value) {
            this.value = value;
        }
    }

    public Long getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}