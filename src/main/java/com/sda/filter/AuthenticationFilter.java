package com.sda.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", value = "/panel/*")
public class AuthenticationFilter implements Filter {

   @Override
   public void init(final FilterConfig filterConfig) throws ServletException {

   }

   @Override
   public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
      final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
      final HttpServletResponse httpServletResponse= (HttpServletResponse) servletResponse;
      final Object user = httpServletRequest.getSession().getAttribute("user");
      if(user == null) {
         System.out.println("User is not logged! Redirecting.");
         httpServletResponse.sendRedirect("/login");
      } else {
         filterChain.doFilter(servletRequest, servletResponse);
      }
   }

   @Override
   public void destroy() {

   }
}
