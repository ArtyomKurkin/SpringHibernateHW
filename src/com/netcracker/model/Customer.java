package com.netcracker.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private int id;

    @Column(name = "surname", nullable=false)
    private String surname;

    @Column(name = "district", nullable=false)
    private String district;

    @Column(name="discount", nullable=false)
    private int discount;

    public Customer(String surname, String district, int discount) {
        this.surname = surname;
        this.district = district;
        this.discount = discount;
    }

    public Customer() {
    }
}

