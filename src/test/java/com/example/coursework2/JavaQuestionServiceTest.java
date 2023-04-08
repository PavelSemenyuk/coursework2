package com.example.coursework2;

import com.example.coursework2.object.Question;
import com.example.coursework2.service.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

//@RunWith(MockitoJUnitRunner.class)
//public class JavaQuestionServiceTest {
//    @MockBean
//    private List<Question> questionList;
//
//
//    private JavaQuestionService javaQuestionService;

//    @Test
//    public void testAddQuestion() {
//        Question question = new Question("Test question", "Test answer");
//        javaQuestionService.questionAdd(question.getQuestion(), question.getAnswer());
//        Mockito.verify(questionList).add(question);
//    }
//
//    @Test
//    public void testRemoveQuestion() {
//        Question question1 = new Question("Test question", "Test answer");
//        javaQuestionService.removeQuestion(question1.getQuestion(), question1.getAnswer());
//        Mockito.verify(questionList).remove(question1);
//    }
//
//    @Test
//    public void testGetAllQuestions() {
//        Mockito.when(questionList.size()).thenReturn(2);
//        Question question1 = new Question("Test question 1", "Test answer 1");
//        Question question2 = new Question("Test question 2", "Test answer 2");
//        Mockito.when(questionList.get(0)).thenReturn(question1);
//        Mockito.when(questionList.get(1)).thenReturn(question2);
//
//        List<Question> questions = javaQuestionService.getAllQuestions();
//    }
//}
