package com.sda.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateAdController", value = "/create-ad")
public class CreateAdController extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("create-ad.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
