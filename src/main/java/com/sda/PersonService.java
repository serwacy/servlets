package com.sda;

public class PersonService {
    public String showPersonData(final Person person){
        return "First name: " + person.getFirstName() +
                "\nLast name: " + person.getLastName() +
                "\nGender: " + person.getGender() +
                "\nAge: " + calculateAge(person.getDateOfBirth());
    }

    private Integer calculateAge(final String birthday){
        final int year = Integer.parseInt(birthday.substring(0, 4));
        return 2020 - year;
    }
}
