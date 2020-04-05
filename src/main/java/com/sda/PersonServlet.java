package com.sda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PersonServlet", value = "/person")
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final Person person = new Person("Grzegorz", "Wanat", 31, "Gdansk");
        httpServletRequest.setAttribute("person", person);
        final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("person.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
