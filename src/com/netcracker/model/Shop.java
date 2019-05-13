package com.netcracker.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="shop")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name="id")
    private int id;

    @Column(name="title", nullable = false)
    @NonNull
    private String title;

    @Column(name="district", nullable=false)
    @NonNull
    private String district;

    @Column(name="comission", nullable = false)
    @NonNull
    private int comission;
}
