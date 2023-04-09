package com.example.coursework2.controller;

import com.example.coursework2.exception.MoreQuestionsAskedException;
import com.example.coursework2.object.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.coursework2.service.ExaminerService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/exam/get")
public class ExamController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MoreQuestionsAskedException.class, MoreQuestionsAskedException.class})
    public String handleException(RuntimeException e) {
        return String.format("%s %s", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getJavaQuestions(@PathVariable("amount") int amount) throws MoreQuestionsAskedException {
        return examinerService.getQuestion(amount);
    }
}
