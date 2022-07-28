package service;

import exceptions.RequestedQuantityExceededException;
import model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    Random random = new Random();

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
        if (amount <= 0 || amount > questionService.size()+1) {
            throw new RequestedQuantityExceededException();
        }
        while (questionSet.size() < amount) {
            int digitForChange = random.nextInt(2);
            if (digitForChange == 0 && questionService.size() > 0 ){
                questionSet.add(questionService.getRandomQuestion());
            } else {
                questionSet.add(questionService.getRandomQuestion());
            }
        }
        return Collections.unmodifiableCollection(questionSet);
        }
}
