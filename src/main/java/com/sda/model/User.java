package com.sda.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class User {
    private String name;
    private String surname;
    private String login;
    private String password;
}
