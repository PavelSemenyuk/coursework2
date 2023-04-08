package com.example.coursework2.service;

import com.example.coursework2.exception.MoreQuestionsAskedException;
import com.example.coursework2.object.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestion(int amount) {
        List<Question> questions = new ArrayList<>();
        Set<Question> indexQuestions = new HashSet<>();

        while (questions.size() < amount) {
            Question question = questionService.getRandomQuestion();
            if (indexQuestions.contains(question)) {
                continue;
            }
            indexQuestions.add(question);
            questions.add(question);
            if (questions.size() > questionService.getAllQuestions().size()) {
                throw new MoreQuestionsAskedException("Запрошено большее количество вопросов!");
            }
        }

        return questions;
    }

}
