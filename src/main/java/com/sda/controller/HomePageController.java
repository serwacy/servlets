package com.sda.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomePageController", value = "/")
public class HomePageController extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("content", "home");
        final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
