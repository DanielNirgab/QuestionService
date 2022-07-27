package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongQuestion extends RuntimeException {
    public WrongQuestion() {
        super("Question is Null");
    }
}
