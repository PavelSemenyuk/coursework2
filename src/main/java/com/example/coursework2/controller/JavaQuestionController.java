package com.example.coursework2.controller;

import com.example.coursework2.exception.MoreQuestionsAskedException;
import com.example.coursework2.object.Question;
import com.example.coursework2.service.JavaQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(name = "/exam/java")
public class JavaQuestionController {
    @Autowired
    private JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping(path = "/add")
    public void addQuestion(@RequestParam (name = "question") String question, @RequestParam (name = "answer") String answer) {
       javaQuestionService.addQuestion(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getAllQuestions() {
        return  javaQuestionService.getAllQuestions();
    }

    @GetMapping(path = "/remove")
    public void removeQuestion(@RequestParam (name = "question") String question, @RequestParam (name = "answer") String answer) {
        javaQuestionService.removeQuestion(question, answer);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MoreQuestionsAskedException.class)
    public String handleException(MoreQuestionsAskedException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

}
