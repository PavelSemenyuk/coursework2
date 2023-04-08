package com.example.coursework2.service;

import com.example.coursework2.object.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {


    private Set<Question> questionSet = new HashSet<>();

    @Override
    public Question questionAdd(String question, String answer) {
        Question question1 = new Question(question,answer);
        return question1;
    }
    @Override
    public Question addQuestion(Question question) {
        questionSet.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        Question question2= new Question(question, answer);
        questionSet.remove(question2);
        return question2;
    }

    @Override
    public List<Question> getAllQuestions() {
        return new ArrayList<>(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questionSet.size());
        return questionSet.toArray(new Question[0])[index];
    }


}
