package com.sda.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Advert {
    private String id;
    private int price;
    private String currency;
    private Car car;
    private String userLogin;
    private String createdAt;
}
