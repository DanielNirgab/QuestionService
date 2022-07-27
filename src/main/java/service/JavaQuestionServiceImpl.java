package service;

import exceptions.NoQuestionsAddedException;
import exceptions.QuestionNotFoundException;
import exceptions.WrongQuestion;
import org.springframework.stereotype.Service;
import model.Question;

import java.util.*;

@Service
public class JavaQuestionServiceImpl implements QuestionService  {

   private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        initQandA(question, answer);
        Question question1 = new Question(question, answer);
        questions.add(question1);
        return question1;
    }

    @Override
    public Question add(Question question) {
        initQuestion(question);
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        initQuestion(question);
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public List<Question> getAll() {
        noElementsAdded();
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        noElementsAdded();
        Random random = new Random();
        List<Question> questionsArrayList = new ArrayList<>(this.getAll());
        return questionsArrayList.get(random.nextInt(questionsArrayList.size()));
    }

    private void initQuestion(Question question) {
        if (question == null) {
            throw new WrongQuestion();
        }
    }
    private void initQandA(String question, String answer) {
        if (question == null || answer == null) {
            throw new WrongQuestion();
        }
    }

    private void noElementsAdded() {
        if (questions.isEmpty()) {
            throw new NoQuestionsAddedException();
        }
    }
    @Override
    public boolean isEmpty() {
        return questions.isEmpty();
    }

    @Override
    public int size() {
        return questions.size();
    }
    @Override
    public Question get(int i) {
        List<Question> questionsArrayList = new ArrayList<>(questions);
        return questionsArrayList.get(i);
            }


}

