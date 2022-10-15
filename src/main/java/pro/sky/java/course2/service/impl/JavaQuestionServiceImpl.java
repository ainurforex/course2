package pro.sky.java.course2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.Question;
import pro.sky.java.course2.exception.QuestionAlreadyContainsException;
import pro.sky.java.course2.exception.QuestionNotFoundException;
import pro.sky.java.course2.service.QuestionService;

import java.util.*;


@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private final Set<Question> questions;

    public JavaQuestionServiceImpl() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyContainsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
