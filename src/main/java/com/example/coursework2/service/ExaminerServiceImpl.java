package com.example.coursework2.service;

import com.example.coursework2.exception.MoreQuestionsAskedException;
import com.example.coursework2.object.Question;

import java.util.*;

public class ExaminerServiceImpl implements ExaminerService {

    private  QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public List<Question> getQuestion(int amount)  {
        List<Question> questions = new ArrayList<>();
        Set<Question> usedQuestions = new HashSet<>();

        while(questions.size() < amount) {
            Question question = questionService.getRandomQuestion();
            if(usedQuestions.contains(question)) {
                continue;
            }
            usedQuestions.add(question);
            questions.add(question);
            if(questions.size() > questionService.getAllQuestions().size()) {
                throw new MoreQuestionsAskedException("Запрошено большее количество вопросов!");
            }
        }

        return questions;
    }

}
