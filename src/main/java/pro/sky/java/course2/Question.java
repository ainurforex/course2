package pro.sky.java.course2;

import java.util.Objects;

public class Question {
    private final String question;
    private final String answer;

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question questionCompr = (Question) o;
        return Objects.equals(getQuestion(), questionCompr.getQuestion()) && Objects.equals(getAnswer(), questionCompr.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuestion(), getAnswer());
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
