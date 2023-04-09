package com.example.coursework2.service;

import com.example.coursework2.object.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {


    public List<Question> javaQuestions = new ArrayList<>();


    @Override
    public Question addQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        javaQuestions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        javaQuestions.remove(new Question(question, answer));
        return new Question(question, answer);
    }

    @Override
    public Collection<Question> getAllQuestions() {
        return javaQuestions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(javaQuestions.size());
        return javaQuestions.get(index);
    }


}
