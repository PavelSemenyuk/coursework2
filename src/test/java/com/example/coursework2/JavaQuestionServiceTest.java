package com.example.coursework2;

import com.example.coursework2.object.Question;
import com.example.coursework2.service.JavaQuestionService;
import com.example.coursework2.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {JavaQuestionService.class})
@ExtendWith(SpringExtension.class)
public class JavaQuestionServiceTest {
    @MockBean
    private List<Question> questionList;
    @Autowired
    private JavaQuestionService javaQuestionService;

    @Test
    public void testAddQuestion() {

        // Создаю объект JavaQuestionService с вопросами
        Question question = new Question("question", "answer");
        javaQuestionService.add(question);

        // Вызываем метод addQuestion с аргументами вопрос ответ
        Question result = javaQuestionService.addQuestion("question", "answer");

        // Проверяю, что метод addQuestion был вызван у javaQuestions с  result
        questionList.add(result);


        assertEquals(question, result);
//        assertEquals("question", result.getQuestion());
//        assertEquals("answer", result.getAnswer());
    }

    @Test
    public void testRemoveQuestion() {

        // Создаю  вопрос-ответ и добавляем в questionList
        Question question = new Question("Test question", "Test answer");
        questionList.add(question);

        // Вызываем метод removeQuestion с аргументами "Test question" и "Test answer"
        Question result = javaQuestionService.removeQuestion("Test question", "Test answer");

        assertEquals(question, result);
//        assertEquals("Test question", result.getQuestion());
//        assertEquals("Test answer", result.getAnswer());

    }

    @Test
    public void testGetAllQuestions() {
        Mockito.when(questionList.size()).thenReturn(2);
        Question question1 = new Question("Test question 1", "Test answer 1");
        Question question2 = new Question("Test question 2", "Test answer 2");
        Mockito.when(questionList.get(0)).thenReturn(question1);
        Mockito.when(questionList.get(1)).thenReturn(question2);

        List<Question> questions = javaQuestionService.javaQuestions;


    }

//    @Test
//    public void testGetRandomQuestion() {
//        // Создаю список вопросов и добавляю туда несколько объектов Question
//        List<Question> allQuestions = new ArrayList<>();
//        allQuestions.add(new Question("1 + 1", "2"));
//        allQuestions.add(new Question("2 + 2", "4"));
//        allQuestions.add(new Question("5 + 5", "10"));
//
//        // Создаем объект JavaQuestionService и вызываю в него список вопросов
//        JavaQuestionService questionService = new JavaQuestionService();
//        questionService.getAllQuestions();
//
//
//        // Создаем мок-объект для класса Random. Этот код нашел на stackoverflow.
//        MockedStatic<Random> randomMockedStatic = mockStatic(Random.class);
//        Random random = mock(Random.class);
//        when(random.nextInt(allQuestions.size())).thenReturn(1);
//        randomMockedStatic.when(Random::new).thenReturn(random);
//
//        // Вызываем метод getRandomQuestion и проверяем, что он вернул правильный вопрос
//        Question question = questionService.getRandomQuestion();
//        assertEquals(allQuestions, question);
//        assertEquals("1 + 1", question.getQuestion());
//        assertEquals("2", question.getAnswer());
//
//        // Отключаем мок класса Random. Это тоже взял с stackoverflow
//        randomMockedStatic.close();
//    }

//    @Test
//    public void testGetRandomQuestion1() {
//        List<Question> ofQuestions = new ArrayList<>();
//        ofQuestions.add(new Question("1 + 1", "2"));
//        ofQuestions.add(new Question("2 + 2", "4"));
//        ofQuestions.add(new Question("5 + 5", "10"));
//
//        JavaQuestionService questions1 = new JavaQuestionService();
//        Question randomQuestion = questions1.getRandomQuestion();
//
//        assertEquals(ofQuestions, randomQuestion);
//    }

}




