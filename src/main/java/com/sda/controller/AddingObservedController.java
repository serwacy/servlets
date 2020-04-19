package com.sda.controller;

import com.sda.service.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddingObservedController", value = "/panel/adding")
public class AddingObservedController extends HttpServlet {
   private AdvertService advertService = AdvertService.aAdvertService();

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {

   }
}
