package com.netcracker.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="shop")
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private int id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="district", nullable=false)
    private String district;

    @Column(name="comission", nullable = false)
    private int comission;


    public Shop(String title, String district, int comission) {
        this.title = title;
        this.district = district;
        this.comission = comission;
    }

    public Shop() {
    }
}
