package com.example.coursework2.service;

import com.example.coursework2.object.Question;

import java.util.List;

public interface QuestionService {
    void questionAdd (String question, String answer);
    void addQuestion(Question question);
    void removeQuestion(Question question);
    List<Question>getAllQuestions();
    Question getRandomQuestion();
}
