package com.sda.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Car {
    private int productionYear;
    private String company;
    private String model;
    private int mileage;
}
