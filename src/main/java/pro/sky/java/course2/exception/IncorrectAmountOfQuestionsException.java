package pro.sky.java.course2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectAmountOfQuestionsException extends RuntimeException {

    public IncorrectAmountOfQuestionsException() {
    }

    public IncorrectAmountOfQuestionsException(String message) {
        super(message);
    }
}
