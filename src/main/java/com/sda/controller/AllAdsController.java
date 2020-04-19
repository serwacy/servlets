package com.sda.controller;

import com.sda.model.Advert;
import com.sda.service.AdvertService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "AllAdsController", value = "/panel/all-ads")
public class AllAdsController extends HttpServlet {
    private AdvertService advertService = AdvertService.aAdvertService();

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final List<Advert> adverts = advertService.getAllAdverts();
        isAdvertListEmpty(adverts, httpServletRequest);
        httpServletRequest.setAttribute("adverts", adverts);
        httpServletRequest.setAttribute("filters", "active");
        final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/ads.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Advert> adverts = advertService.getAllAdverts();
        final String make = httpServletRequest.getParameter("make");
        final Integer priceMin = Integer.parseInt(httpServletRequest.getParameter("price-min"));
        final Integer priceMax = Integer.parseInt(httpServletRequest.getParameter("price-max"));
        final Integer mileageMin = Integer.parseInt(httpServletRequest.getParameter("mileage-min"));
        final Integer mileageMax = Integer.parseInt(httpServletRequest.getParameter("mileage-max"));
        final Integer productionYearMin = Integer.parseInt(httpServletRequest.getParameter("production-year-min"));
        final Integer productionYearMax = Integer.parseInt(httpServletRequest.getParameter("production-year-max"));
        if(!make.equals("any")) {
            adverts = adverts.stream()
                    .filter(advert -> advert.getCar().getMake().equals(make))
                    .collect(Collectors.toList());
        }
        if (checkFilterLowerBounds(0, priceMin)){
            adverts = adverts.stream()
                    .filter(advert -> advert.getPrice() > priceMin)
                    .collect(Collectors.toList());
        }
        if (!priceMax.toString().isEmpty()) {
            adverts = adverts.stream()
                    .filter(advert -> advert.getPrice() < priceMax)
                    .collect(Collectors.toList());
        }
        if (checkFilterLowerBounds(0, mileageMin)){
            adverts = adverts.stream()
                    .filter(advert -> advert.getCar().getMileage() > mileageMin)
                    .collect(Collectors.toList());
        }
        if (!mileageMax.toString().isEmpty()) {
            adverts = adverts.stream()
                    .filter(advert -> advert.getCar().getMileage() < mileageMax)
                    .collect(Collectors.toList());
        }
        if (checkFilterLowerBounds(1900, productionYearMin)){
            adverts = adverts.stream()
                    .filter(advert -> advert.getCar().getProductionYear() > productionYearMin)
                    .collect(Collectors.toList());
        }
        if (productionYearMax < 2020) {
            adverts = adverts.stream()
                    .filter(advert -> advert.getCar().getProductionYear() < productionYearMax)
                    .collect(Collectors.toList());
        }
        isAdvertListEmpty(adverts, httpServletRequest);
        httpServletRequest.setAttribute("adverts", adverts);
        httpServletRequest.setAttribute("filters", "active");
        httpServletRequest.getRequestDispatcher("/ads.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    private void isAdvertListEmpty(final List<Advert> adverts, final HttpServletRequest httpServletRequest) {
        if(adverts.isEmpty()){
            httpServletRequest.setAttribute("isEmpty", "empty");
        }
    }

    private boolean checkFilterLowerBounds (final Integer bound, final Integer input) {
        return bound <= input;
    }
}