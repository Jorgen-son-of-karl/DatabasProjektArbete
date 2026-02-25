package com.karlsson.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Long rentalId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RentalType rentalType;

    @Column(nullable = false)
    private Long rentalObjectId;


    @Column(name = "start_date",nullable = false)
    private Instant startDate = Instant.now();

    @Column(name ="end_date",nullable = false)
    private LocalDate endDate;

    private Double totalPrice;

    @Column(nullable = false)
    private boolean returned = false;

    protected Rental() {}

    public Rental(Member member,
                  RentalType rentalType,
                  Long rentalObjectId){
        this.member = member;
        this.rentalType = rentalType;
        this.rentalObjectId = rentalObjectId;
    }

    public enum RentalType {
        INSTRUMENT,
        AUDIO_EQUIPMENT,
        ACCESSORY
    }

    public Long getId() { return rentalId; }
    public Member getMember() { return member; }
    public RentalType getRentalType() { return rentalType; }
    public Long getRentalObjectId() { return rentalObjectId; }
    public Instant getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public Double getTotalPrice() { return totalPrice; }
    public boolean isReturned() { return returned; }

    public void closeRental(LocalDate endDate, double totalPrice) {
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.returned = true;
    }
}
