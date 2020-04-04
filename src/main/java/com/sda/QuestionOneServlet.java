package com.sda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuestionOneServlet", value = "/questionOne")
public class QuestionOneServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("questionOne.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String answer = httpServletRequest.getParameter("answerOne");
        final QuizService service = new QuizService();

        final boolean result = service.answerVerifier(answer, "berlin");
        if(result){
            httpServletResponse.sendRedirect("/questionTwo");
        } else {
            httpServletResponse.getWriter().print("Wrong answer, you're bad at geography!");
        }
    }
}
