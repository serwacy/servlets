package com.sda;

public class CityAdvisorService {
    public String getClubByCity(final String city){
        if(city.equals("Warszawa")){
            return "Legia Warszawa";
        } else if (city.equals("Lodz")){
            return "Widzew Lodz";
        } else if (city.equals("Gdansk")){
            return "Lechia Gdansk";
        } else {
            return "Lechia Gdansk";
        }
    }
}
