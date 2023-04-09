package com.example.coursework2.service;

import com.example.coursework2.exception.MoreQuestionsAskedException;
import com.example.coursework2.object.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {

        if(amount < 1) {
            throw new MoreQuestionsAskedException("Номер вопроса не может быть отрицательным или 0");
        }
        if (amount > questionService.getAllQuestions().size()) {
            throw new MoreQuestionsAskedException("Запрошено большее количество вопросов!");
        }

        Set<Question> index = new HashSet<>();
        while (index.size() < amount) {
            index.add(questionService.getRandomQuestion());
        }
        return index;
    }

}
