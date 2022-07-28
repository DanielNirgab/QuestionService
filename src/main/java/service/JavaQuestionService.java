package service;

import exceptions.NoQuestionsAddedException;
import exceptions.QuestionNotFoundException;
import exceptions.WrongQuestion;
import org.springframework.stereotype.Service;
import model.Question;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService  {

   private final Set<Question> questions = new HashSet<>();

    Random random = new Random();

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
    public String remove(String question) {
        Map<String, List<Question>> questionMap = questions.stream()
                .filter(question1 -> question1.getQuestion().contains(question))
                .collect(Collectors.groupingBy(Question::getQuestion, Collectors.toList()));

        if (!questionMap.containsKey(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(questionMap.get(question).get(0));
        return question;
    }

    @Override
    public List<Question> getAll() {
        noElementsAdded();
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
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

