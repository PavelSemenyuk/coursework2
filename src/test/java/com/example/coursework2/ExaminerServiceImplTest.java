package com.example.coursework2;

import com.example.coursework2.object.Question;
import com.example.coursework2.service.ExaminerService;
import com.example.coursework2.service.ExaminerServiceImpl;
import com.example.coursework2.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ExaminerServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class ExaminerServiceImplTest {
    @Autowired
    ExaminerService examinerService;

    @MockBean
    QuestionService questionServiceMock;

    @Test
    void getRandom_method_of_ExamService_success() {
        //  Входные данные
        Question question1 = new Question("1 + 1", "2");
        Question question2 = new Question("2 + 2", "4");
        Question question3 = new Question("3 + 3", "6");
        Question question4 = new Question("4 + 4", "8");
        Question question5 = new Question("5 + 5", "10");
        Set<Question> questionSet = new HashSet<>();
        questionSet.add(question1);
        questionSet.add(question2);
        questionSet.add(question3);
        questionSet.add(question4);
        questionSet.add(question5);

        // Подготовка ожидаемого результата
        when(questionServiceMock.getAllQuestions()).thenReturn(questionSet);

        // Начало теста
        Set<Question> actualResult = new HashSet<>(questionSet);
        assertEquals(actualResult, examinerService.getQuestion(2));
    }
}
