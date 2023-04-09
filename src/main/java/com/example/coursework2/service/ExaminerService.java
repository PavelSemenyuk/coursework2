package com.example.coursework2.service;

import com.example.coursework2.object.Question;

import java.util.Collection;
import java.util.List;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
