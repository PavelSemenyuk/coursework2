package com.example.coursework2.service;

import com.example.coursework2.object.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface QuestionService {
    Question questionAdd (String question, String answer);
    Question addQuestion(Question question);
    Question removeQuestion(String question, String answer);
    Collection<Question> getAllQuestions();
    Question getRandomQuestion();
}
