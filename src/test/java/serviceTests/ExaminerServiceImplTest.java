package serviceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.ExaminerServiceImpl;
import service.JavaQuestionServiceImpl;

import java.util.List;

import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionServiceImpl javaServiceMock;
    private ExaminerServiceImpl out;


    @BeforeEach
    public void init () {
        out = new ExaminerServiceImpl(List.of(javaServiceMock));
    }

    @Test
    public void shouldReturnSomeNotNullCollection() {
        when(javaServiceMock.getRandomQuestion())
                .thenReturn(CORRECT_QUESTION);
        assertIterableEquals(CORRECT_EXAM_COLLECTION, out.getQuestions(1));
    }
}
