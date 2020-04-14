package com.sda.controller;

import com.sda.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    private UserService userService = UserService.aUserService();

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String login = httpServletRequest.getParameter("login");
        final String password = httpServletRequest.getParameter("password");

        switch (userService.loginUser(login, password)) {
            case "correctInput":
                final HttpSession session = httpServletRequest.getSession();
                session.setAttribute("user", userService.getUserByLogin(login));
                httpServletRequest.getRequestDispatcher("home.jsp")
                        .forward(httpServletRequest, httpServletResponse);
                break;
            case "noSuchLogin":
                httpServletRequest.setAttribute("noSuchLogin", login);
                httpServletRequest.getRequestDispatcher("login.jsp")
                        .forward(httpServletRequest, httpServletResponse);
                break;
            case "wrongPassword":
                httpServletRequest.setAttribute("wrongPassword", password);
                httpServletRequest.getRequestDispatcher("login.jsp")
                        .forward(httpServletRequest, httpServletResponse);
                break;
            default:
                httpServletRequest.setAttribute("content", "home");
                httpServletRequest.getRequestDispatcher("home.jsp")
                        .forward(httpServletRequest, httpServletResponse);
                break;
        }
    }
}
