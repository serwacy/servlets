package com.sda.repository;

import com.sda.model.Advert;
import com.sda.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdvertRepository {
    private static AdvertRepository advertRepository;
    private List<Advert> adverts;

    public static AdvertRepository aAdvertRepository() {
        if(advertRepository == null) {
            advertRepository = new AdvertRepository(new ArrayList<>());
        }
        return advertRepository;
    }

    public boolean addAdvert(final Advert advert) {
        return adverts.add(advert);
    }

    public List<Advert> getAllAdverts() {
        return adverts;
    }

    public List<Advert> getAdvertsByUser(final User user) {
        return adverts.stream()
                .filter(advert -> advert.getUserLogin().equals(user.getLogin()))
                .collect(Collectors.toList());
    }
    public Advert getAdvertById(final String id){
        return adverts.stream()
                .filter(advert -> advert.getId().equals(id))
                .findAny().get();
    }
}
