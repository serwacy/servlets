package com.sda.controller;

import com.sda.model.User;
import com.sda.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {
    private UserService userService = UserService.aUserService();

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("register.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final User user = createUserFrom(httpServletRequest);
        final boolean created = userService.registerUser(user);
        if(created) {
            httpServletRequest.getRequestDispatcher("home.jsp")
                    .forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute("loginExists", user.getLogin());
            httpServletRequest.getRequestDispatcher("register.jsp")
                    .forward(httpServletRequest, httpServletResponse);
        }
    }

    private User createUserFrom (final HttpServletRequest httpServletRequest) {
        return User.builder()
                .login(httpServletRequest.getParameter("login"))
                .name(httpServletRequest.getParameter("name"))
                .surname(httpServletRequest.getParameter("surname"))
                .password(httpServletRequest.getParameter("password"))
                .build();
    }
}
