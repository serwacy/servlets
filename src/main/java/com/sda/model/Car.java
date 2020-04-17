package com.sda.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Car {
    private int productionYear;
    private String make;
    private String model;
    private int mileage;
}
