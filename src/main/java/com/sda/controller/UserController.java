package com.sda.controller;

import com.sda.model.User;
import com.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", value = "/panel/users")
public class UserController  extends HttpServlet {
   private UserService userService = UserService.aUserService();

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final List<User> users = userService.getAll();
      httpServletRequest.setAttribute("users", users);
      httpServletRequest.getRequestDispatcher("/users.jsp").forward(httpServletRequest,httpServletResponse);
   }
}
