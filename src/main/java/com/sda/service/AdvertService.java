package com.sda.service;

import com.sda.model.Advert;
import com.sda.model.User;
import com.sda.repository.AdvertRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdvertService {
    private static AdvertService advertService;
    private AdvertRepository advertRepository;

    public static AdvertService aAdvertService() {
        if (advertService == null) {
            advertService = new AdvertService(AdvertRepository.aAdvertRepository());
        }
        return advertService;
    }

    public boolean addAdvert(final Advert advert){
        return advertRepository.addAdvert(advert);
    }

    public List<Advert> getAllAdverts() {
        return advertRepository.getAllAdverts();
    }

    public List<Advert> getAdvertsByUser(final User user) {
        return advertRepository.getAdvertsByUser(user);
    }
    public List<Advert> getObservedAdvertsByUser(final User user) {
        return advertRepository.getAdvertsObservedBy(user);
    }
}