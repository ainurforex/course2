package pro.sky.java.course2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.Question;
import pro.sky.java.course2.exception.QuestionAlreadyContainsException;
import pro.sky.java.course2.exception.QuestionNotFoundException;
import pro.sky.java.course2.service.impl.JavaQuestionServiceImpl;
import java.util.HashSet;

import static pro.sky.java.course2.service.Constant.*;

public class JavaQuestionServiceImplTest {
    private final QuestionService questionService = new JavaQuestionServiceImpl();

    @Test
    public void addTest() {
        Assertions.assertEquals(questionService.getAll().isEmpty(), true);
        questionService.add(QUESTION1);
        Assertions.assertEquals(questionService.getAll().size(), 1);
        Assertions.assertEquals(questionService.getAll().contains(QUESTION1), true);
        questionService.add("Q2", "A2");
        Assertions.assertEquals(questionService.getAll().contains(QUESTION2), true);
        Assertions.assertThrows(QuestionAlreadyContainsException.class, () -> questionService.add(QUESTION2));

    }

    @Test
    public void removeTests() {
        Assertions.assertEquals(questionService.getAll().isEmpty(), true);
        Assertions.assertThrows(QuestionNotFoundException.class, () -> questionService.remove(QUESTION1));
        questionService.add(QUESTION1);
        Assertions.assertEquals(questionService.getAll().size(), 1);
        Assertions.assertEquals(questionService.getAll().contains(QUESTION1), true);
        questionService.remove(QUESTION1);
        Assertions.assertEquals(questionService.getAll().size(), 0);
        Assertions.assertEquals(questionService.getAll().contains(QUESTION1), false);
    }

    @Test
    public void getAllTest() {
        Assertions.assertEquals(questionService.getAll().isEmpty(), true);
        questionService.add(QUESTION1);
        questionService.add(QUESTION2);
        questionService.add(QUESTION3);
        questionService.add(QUESTION4);
        questionService.add(QUESTION5);
        HashSet<Question> questions = (HashSet<Question>) questionService.getAll();
        Assertions.assertEquals(questions.size(), 5);
        Assertions.assertEquals(questions.contains(QUESTION1), true);
        Assertions.assertEquals(questions.contains(QUESTION2), true);
        Assertions.assertEquals(questions.contains(QUESTION3), true);
        Assertions.assertEquals(questions.contains(QUESTION4), true);
        Assertions.assertEquals(questions.contains(QUESTION5), true);

    }
    @Test
    public void getRandomQuestionTest() {
        Assertions.assertEquals(questionService.getAll().isEmpty(), true);
        questionService.add(QUESTION1);
        questionService.add(QUESTION2);
        questionService.add(QUESTION3);
        questionService.add(QUESTION4);
        questionService.add(QUESTION5);
        Assertions.assertEquals(questionService.getAll().size(), 5);
        Assertions.assertEquals(questionService.getAll().contains(questionService.getRandomQuestion()), true);


    }
}
