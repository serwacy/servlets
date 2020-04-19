package com.sda.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Value
public class Advert {
    private int price;
    private String currency;
    private Car car;
    private User user;
    private String createdAt;
    private List<User> observedBy;
}
