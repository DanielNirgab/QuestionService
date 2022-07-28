package serviceTests;

import exceptions.RequestedQuantityExceededException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.ExaminerServiceImpl;
import service.JavaQuestionService;


import static constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;


    @Test
    public void shouldReturnSomeNotNullCollection() {
        when(javaServiceMock.getRandomQuestion())
                .thenReturn(CORRECT_QUESTION);
        assertIterableEquals(CORRECT_EXAM_COLLECTION, out.getQuestions(1));
    }
    @Test
    public void shouldReturnAmountException() {
        assertThrows(RequestedQuantityExceededException.class, () -> out.getQuestions(2));
    }
}
