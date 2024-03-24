package com.assignment.dto;

import com.assignment.entity.Shopper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopperProductDTO {

    private String productId;
    private double relevancyScore;

}

