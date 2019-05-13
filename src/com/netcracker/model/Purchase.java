package com.netcracker.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="purchasee")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private int id;

    @Column(name="date")
    @NonNull
    private Date date;

    @ManyToOne
    @JoinColumn(name="shop")
    @NonNull
    private Shop shop;

    @ManyToOne
    @JoinColumn(name="customer")
    @NonNull
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="book")
    @NonNull
    private Book book;

    @Column(name="number")
    @NonNull
    private int number;

    @Column(name="total")
    @NonNull
    private int total;


}
