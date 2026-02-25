package com.karlsson.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_id")
    private Long memberId;

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, length = 120, unique = true)
    private String email;

    @OneToMany(mappedBy = "member",
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Rental> rentals = new ArrayList<>();

    protected Member() {}

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public Long getId() {return memberId;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public List<Rental> getRentals() {return rentals;}

    public void addRental(Rental rental) {
        rentals.add(rental);
    }
}
