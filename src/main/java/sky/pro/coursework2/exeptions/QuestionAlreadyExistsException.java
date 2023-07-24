package sky.pro.coursework2.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAlreadyExistsException extends RuntimeException{

    public QuestionAlreadyExistsException(String message) {
        super(message);
    }


}
