package com.sda;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuestionThreeServlet", value = "/questionThree")
public class QuestionThreeServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("questionThree.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String answer = httpServletRequest.getParameter("answerThree");
        final QuizService service = new QuizService();

        final boolean result = service.answerVerifier(answer, "madrid");
        if(result){
            httpServletResponse.getWriter().print("All answers were correct, you're good at geography!!!");
        } else {
            httpServletResponse.getWriter().print("Wrong answer, you're bad at geography!");
        }
    }
}
