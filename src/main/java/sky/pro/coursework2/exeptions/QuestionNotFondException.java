package sky.pro.coursework2.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionNotFondException  extends RuntimeException{
    public QuestionNotFondException(String message) {
        super(message);
    }
}
