package com.netcracker.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="book")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private int id;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name="cost")
    @NonNull
    private int cost;

    @Column(name="storage")
    @NonNull
    private String storage;

    @Column(name="count")
    @NonNull
    private int count;




}
