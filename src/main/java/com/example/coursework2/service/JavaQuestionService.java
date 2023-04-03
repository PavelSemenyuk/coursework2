package com.example.coursework2.service;

import com.example.coursework2.object.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private List<Question> questionList = new ArrayList<>();

    public JavaQuestionService() {
        questionList.add(
                new Question("Конструкция языка, позволяющая выполнять один и тот же код многократно в зависимости от условий?", "Цикл"));
        questionList.add(
                new Question("Упорядоченная структура данных фиксированного размера?", "Массив"));
        questionList.add(
                new Question("Неизменяемый массив символов?", "Строка"));
        questionList.add(
                new Question("Два обычных метода, которые используются для получения значения поля класса или его изменения.?", "Геттеры и сеттеры"));
        questionList.add(
                new Question("Особый метод, задача которого - в случае необходимости создать объект, мы обязаны корректно инициализировать его?", "Конструктор"));
    }

    @Override
    public void questionAdd(String question, String answer) {
       // questionList.add();
    }

    @Override
    public void addQuestion(Question question) {
        questionList.add(question);

    }

    @Override
    public void removeQuestion(Question question) {
        questionList.remove(question);

    }

    @Override
    public List<Question> getAllQuestions() {
        return questionList;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questionList.size());
        return questionList.get(index);
    }

}
