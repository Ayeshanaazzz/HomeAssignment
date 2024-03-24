package com.assignment.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table
public class ShelfItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "shopper_id")
    private Shopper shopper;

    private Double relevancyScore;


}
