package com.sda.controller;

import com.sda.model.Advert;
import com.sda.model.User;
import com.sda.service.AdvertService;
import com.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddingObservedController", value = "/panel/adding")
public class AddingObservedController extends HttpServlet {
   private AdvertService advertService = AdvertService.aAdvertService();
   private UserService userService = UserService.aUserService();

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final String observed = httpServletRequest.getParameter("observed");
      final Advert advert = advertService.getAdvertById(httpServletRequest.getParameter("id"));
      final User user = (User) httpServletRequest.getSession().getAttribute("user");

      userService.handleObservedAds(user, advert, observed);
      httpServletResponse.sendRedirect("/panel/all-ads");
   }
}
