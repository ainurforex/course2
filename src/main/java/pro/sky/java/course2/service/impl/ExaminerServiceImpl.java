package pro.sky.java.course2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.Question;
import pro.sky.java.course2.exception.IncorrectAmountOfQuestionsException;
import pro.sky.java.course2.service.ExaminerService;
import pro.sky.java.course2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectAmountOfQuestionsException();
        }
        Set<Question> questions = new HashSet<>(amount);
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
