package pro.sky.kkp_2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistsQuestionException extends RuntimeException {

    public ExistsQuestionException(String message) {
        super(message);
    }
}
