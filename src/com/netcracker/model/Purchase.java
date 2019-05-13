package com.netcracker.model;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="purchasee")
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private int id;

    @Column(name="date")
    private Date date;

    @ManyToOne
    @JoinColumn(name="shop")
    private Shop shop;

    @ManyToOne
    @JoinColumn(name="customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="book")
    private Book book;

    @Column(name="number")
    private int number;

    @Column(name="total")
    private int total;

    public Purchase(Date date, Shop shop, Customer customer, Book book, int number, int total) {
        this.date = date;
        this.shop = shop;
        this.customer = customer;
        this.book = book;
        this.number = number;
        this.total = total;
    }

    public Purchase() {
    }
}
