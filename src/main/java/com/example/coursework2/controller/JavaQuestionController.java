package com.example.coursework2.controller;

import com.example.coursework2.exception.MoreQuestionsAskedException;
import com.example.coursework2.object.Question;
import com.example.coursework2.service.JavaQuestionService;
import com.example.coursework2.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam (name = "question") String question, @RequestParam (name = "answer") String answer) {
      return questionService.addQuestion(question, answer);
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return  questionService.getAllQuestions();
    }

    @GetMapping(path = "/remove")
    public void removeQuestion(@RequestParam (name = "question") String question, @RequestParam (name = "answer") String answer) {
        questionService.removeQuestion(question, answer);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MoreQuestionsAskedException.class)
    public String handleException(MoreQuestionsAskedException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

}
