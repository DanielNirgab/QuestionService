package service;

import org.springframework.stereotype.Service;
import model.Question;

import java.util.Collection;

@Service
public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();

    boolean isEmpty();

    int size();

    Question get(int i);
}
