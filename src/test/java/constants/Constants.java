package constants;

import model.Question;

import java.util.Collection;
import java.util.List;

public class Constants {
    public final static int ZERO = 0;
    public final static int ONE = 1;
    public final static int TWO = 2;
    public final static String CORRECT_STRING_QUESTION = "CORRECT_STRING_QUESTION?";
    public final static String CORRECT_STRING_ANSWER = "CORRECT_STRING_ANSWER.";
    public final static Question CORRECT_QUESTION = new Question(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER);
    public final static String SECOND_CORRECT_STRING_QUESTION = "SECOND_CORRECT_STRING_QUESTION?";
    public final static String SECOND_CORRECT_STRING_ANSWER = "SECOND_CORRECT_STRING_ANSWER.";
    public final static Question SECOND_CORRECT_QUESTION = new Question(SECOND_CORRECT_STRING_QUESTION, SECOND_CORRECT_STRING_ANSWER);
    public static final Collection<Question> CORRECT_EXAM_COLLECTION = List.of(
            CORRECT_QUESTION
    );
}
