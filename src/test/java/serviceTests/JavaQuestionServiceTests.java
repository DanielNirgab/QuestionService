package serviceTests;

import exceptions.QuestionNotFoundException;
import model.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import service.JavaQuestionService;

import java.util.*;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTests {
    private JavaQuestionService out = new JavaQuestionService();

    @AfterEach
    private void cleanOutList() {
        out = null;
    }

    @Test
    void shouldReturnQuestionWhenAddCorrectStringQuestionAndAnswer() {
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER));
        assertTrue(out.getAll().contains(CORRECT_QUESTION));
    }

    @Test
    void shouldReturnQuestionWhenAddCorrectQuestion() {
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_QUESTION));
        assertTrue(out.getAll().contains(CORRECT_QUESTION));
    }


    @Test
    void shouldReturnCollectionWithoutRemovedQuestion() {
        System.out.println(out.toString());
        out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER);
        out.add(new Question("Q1", "A1"));
        assertEquals(CORRECT_STRING_QUESTION, out.remove(CORRECT_STRING_QUESTION));
        assertThrows(QuestionNotFoundException.class, () -> out.remove(CORRECT_STRING_QUESTION));
        assertFalse(out.getAll().contains(CORRECT_QUESTION));
    }

    @Test
    void shouldReturnCollectionWithAddedQuestion() {
        out.add(CORRECT_QUESTION);
        out.add(SECOND_CORRECT_QUESTION);
        Collection<Question> expected = List.of(CORRECT_QUESTION, SECOND_CORRECT_QUESTION);
        assertTrue(out.getAll().containsAll(expected) && expected.containsAll(out.getAll()));
    }

    @Test
    void shouldReturnRandomQuestion() {
        out.add(CORRECT_QUESTION);
        out.add(SECOND_CORRECT_QUESTION);
        Collection<Question> expected = List.of(CORRECT_QUESTION, SECOND_CORRECT_QUESTION);
        assertTrue(expected.contains(out.getRandomQuestion()));
    }

    @Test
    void shouldReturnSizeWhenAddDifferentQuestions() {
        assertEquals(ZERO, out.size());
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER));
        assertEquals(ONE, out.size());
        assertEquals(SECOND_CORRECT_QUESTION, out.add(SECOND_CORRECT_STRING_QUESTION, SECOND_CORRECT_STRING_ANSWER));
        assertEquals(TWO, out.size());
    }

    @Test
    void shouldReturnSizeOneWhenAddTwoEqualQuestion() {
        assertEquals(ZERO, out.size());
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER));
        assertEquals(CORRECT_QUESTION, out.add(CORRECT_STRING_QUESTION, CORRECT_STRING_ANSWER));
        assertEquals(ONE, out.size());
    }
}
