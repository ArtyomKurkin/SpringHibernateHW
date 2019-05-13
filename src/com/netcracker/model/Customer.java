package com.netcracker.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private int id;

    @Column(name = "surname")
    @NonNull
    private String surname;

    @Column(name = "district")
    @NonNull
    private String district;

    @Column(name="discount")
    @NonNull
    private int discount;


}

