package com.assignment.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


import java.util.List;

@Entity
@Data
public class Shopper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shopperId;

    @OneToMany(mappedBy = "shopper", cascade = CascadeType.ALL)
    private List<ShelfItem> shelf;


}


