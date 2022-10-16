package pro.sky.java.course2.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.Question;


import pro.sky.java.course2.exception.IncorrectAmountOfQuestionsException;
import pro.sky.java.course2.service.impl.ExaminerServiceImpl;
import pro.sky.java.course2.service.impl.JavaQuestionServiceImpl;

import java.util.Collection;
import java.util.HashSet;



import static org.mockito.Mockito.when;
import static pro.sky.java.course2.service.Constant.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionServiceImpl javaQuestionServiceImpl;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    @BeforeEach
    public void beforeEach() {
        Collection<Question> questions = new HashSet<>();
        questions.add(QUESTION1);
        questions.add(QUESTION2);
        questions.add(QUESTION3);
        questions.add(QUESTION4);
        questions.add(QUESTION5);

        when(javaQuestionServiceImpl.getAll()).thenReturn(questions);
    }

    @Test
    public void getQuestionsThrowsIncorrectAmountOfQuestionsExceptionByIncorrectAmount() {
        Assertions.assertThrows(IncorrectAmountOfQuestionsException.class, () -> examinerServiceImpl.getQuestions(0));
        Assertions.assertThrows(IncorrectAmountOfQuestionsException.class, () -> examinerServiceImpl.getQuestions(6));
    }

    @Test
    public void getQuestionsWorking() {
        when(javaQuestionServiceImpl.getRandomQuestion())
                .thenReturn(
                        QUESTION1,
                        QUESTION2,
                        QUESTION3,
                        QUESTION4,
                        QUESTION5
                );
        HashSet<Question> questions = (HashSet<Question>) examinerServiceImpl.getQuestions(5);
        Assertions.assertEquals(questions
                        .contains(QUESTION1)
                        && questions.contains(QUESTION2)
                        && questions.contains(QUESTION3)
                        && questions.contains(QUESTION4)
                        && questions.contains(QUESTION5)
                , true);
    }

}
