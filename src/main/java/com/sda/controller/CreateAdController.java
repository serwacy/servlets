package com.sda.controller;

import com.sda.model.Advert;
import com.sda.model.Car;
import com.sda.model.User;
import com.sda.service.AdvertService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@WebServlet(name = "CreateAdController", value = "/panel/create-ad")
public class CreateAdController extends HttpServlet {
   private AdvertService advertService = AdvertService.aAdvertService();

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/create-ad.jsp");
      requestDispatcher.forward(httpServletRequest, httpServletResponse);
   }

   @Override
   protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final Advert advert = createAdvertFrom(httpServletRequest);
      if (advertService.addAdvert(advert)) {
         httpServletRequest.setAttribute("content", "advert_added");
         httpServletRequest.getRequestDispatcher("/home.jsp")
                 .forward(httpServletRequest, httpServletResponse);
      } else {
         httpServletRequest.setAttribute("content", "error");
         httpServletRequest.getRequestDispatcher("/create-ad.jsp")
                 .forward(httpServletRequest, httpServletResponse);
      }
   }

   private Advert createAdvertFrom(final HttpServletRequest httpServletRequest) {
      final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      return Advert.builder()
              .id(UUID.randomUUID().toString())
              .price(Integer.parseInt(httpServletRequest.getParameter("price")))
              .currency(httpServletRequest.getParameter("currency"))
              .car(createCarFrom(httpServletRequest))
              .userLogin(((User) httpServletRequest.getSession().getAttribute("user")).getLogin())
              .createdAt(LocalDateTime.now().format(formatter))
              .build();
   }

   private Car createCarFrom(final HttpServletRequest httpServletRequest) {
      return Car.builder()
              .productionYear(Integer.parseInt(httpServletRequest.getParameter("production-year")))
              .make(httpServletRequest.getParameter("make"))
              .model(httpServletRequest.getParameter("model"))
              .mileage(Integer.parseInt(httpServletRequest.getParameter("mileage")))
              .build();
   }
}
