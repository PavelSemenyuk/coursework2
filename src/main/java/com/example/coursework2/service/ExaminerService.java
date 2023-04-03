package com.example.coursework2.service;

import com.example.coursework2.object.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestion(int amount);
}
