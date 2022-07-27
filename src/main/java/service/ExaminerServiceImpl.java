package service;

import exceptions.RequestedQuantityExceededException;
import model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices;

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionSet = new HashSet<>();
        if (amount <= 0) {
            throw new RequestedQuantityExceededException();
        }
        Random random = new Random();
        while (questionSet.size() < amount) {
            int digitForChange = random.nextInt(2);
            if (digitForChange == 0 && questionServices.get(0).getAll().size() > 0 ){
                questionSet.add(questionServices.get(0).getRandomQuestion());
            } else {
                questionSet.add(questionServices.get(0).getRandomQuestion());
            }
        }
        return Collections.unmodifiableCollection(questionSet);
        }
}
