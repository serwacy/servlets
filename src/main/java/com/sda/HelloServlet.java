package com.sda;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet",
        initParams = {
                @WebInitParam(name = "city", value = "London"),
                @WebInitParam(name = "times", value = "5")
        },
        value = "/home")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final ServletConfig servletConfig = getServletConfig();
        String city = servletConfig.getInitParameter("city");
        String times = servletConfig.getInitParameter("times");
        httpServletResponse.getWriter().print("I have visited: " + city + " for " + times + " times.");
    }
}
