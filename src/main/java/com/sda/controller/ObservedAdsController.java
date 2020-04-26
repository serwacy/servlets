package com.sda.controller;

import com.sda.model.Advert;
import com.sda.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ObservedAdsController", value = "/panel/observed-ads")
public class ObservedAdsController extends HttpServlet {

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final User user = (User) httpServletRequest.getSession().getAttribute("user");
      final List<Advert> adverts = user.getObservedAds();
      if(adverts.isEmpty()){
         httpServletRequest.setAttribute("isEmpty", "empty");
      }
      httpServletRequest.setAttribute("adverts", adverts);
      httpServletRequest.setAttribute("filters", "inactive");
      final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/ads.jsp");
      requestDispatcher.forward(httpServletRequest, httpServletResponse);
   }
}
