package com.example.coursework2.controller;

import com.example.coursework2.exception.MoreQuestionsAskedException;
import com.example.coursework2.object.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursework2.service.ExaminerService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private  ExaminerService examinerService;


    @GetMapping("/java")
    public List<Question> getJavaQuestions(@RequestParam int amount) throws MoreQuestionsAskedException {
        return examinerService.getQuestion(amount);
    }
}
