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
        final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("person.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String firstName = httpServletRequest.getParameter("firstName");
        final String lastName = httpServletRequest.getParameter("lastName");
        final String gender = httpServletRequest.getParameter("gender");
        final String birthday = httpServletRequest.getParameter("birthday");

        final Person person = new Person(firstName, lastName, gender, birthday);

        final PersonService service = new PersonService();

        httpServletResponse.getWriter().print(service.showPersonData(person));
    }
}
