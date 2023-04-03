package com.example.coursework2.controller;

import com.example.coursework2.exception.MoreQuestionsAskedException;
import com.example.coursework2.object.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.coursework2.service.JavaQuestionService;

import java.util.List;

@RestController
@RequestMapping(name = "/exam/java")
public class JavaQuestionController {
    @Autowired
    private JavaQuestionService javaQuestionService;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MoreQuestionsAskedException.class)
    public String handleException(MoreQuestionsAskedException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @GetMapping(path = "/add")
    public void addQuestion(@RequestParam (name = "question") String question, @RequestParam (name = "answer") String answer) {
       javaQuestionService.addQuestion(new Question(question, answer));
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return javaQuestionService.getAllQuestions();
    }

    @GetMapping(path = "/remove")
    public void removeQuestion(@RequestParam (name = "question") String question, @RequestParam (name = "answer") String answer) {
        javaQuestionService.removeQuestion(new Question(question, answer));
    }


}
