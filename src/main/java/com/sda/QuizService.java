package com.sda;

public class QuizService {
    public boolean answerVerifier(final String submittedAnswer, final String correctAnswer){
        return submittedAnswer.toLowerCase().equals(correctAnswer);
    }
}
