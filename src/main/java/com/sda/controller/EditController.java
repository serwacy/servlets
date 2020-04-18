package com.sda.controller;

import com.sda.model.User;
import com.sda.request.EditUserRequest;
import com.sda.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditController", value = "/panel/edit")
public class EditController extends HttpServlet {
   private UserService userService = UserService.aUserService();

   @Override
   protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final String login = httpServletRequest.getParameter("login");
      final User user = userService.getUserByLogin(login);
      httpServletRequest.setAttribute("user", user);
      httpServletRequest.getRequestDispatcher("/edit.jsp").forward(httpServletRequest, httpServletResponse);
   }

   @Override
   protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
      final String login = httpServletRequest.getParameter("login");
      final String newName = httpServletRequest.getParameter("name");
      final String newSurname = httpServletRequest.getParameter("surname");
      final EditUserRequest request = new EditUserRequest(newName, newSurname, login);

      userService.updateUser(request);
      httpServletResponse.sendRedirect("/panel/users");
   }
}
