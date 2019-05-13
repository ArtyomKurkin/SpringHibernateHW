package com.netcracker.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name="cost")
    private int cost;

    @Column(name="storage")
    private String storage;

    @Column(name="count")
    private int count;


    public Book(String title, int cost, String storage, int count) {
        this.title = title;
        this.cost = cost;
        this.storage = storage;
        this.count = count;
    }

    public Book(){

    }
}
