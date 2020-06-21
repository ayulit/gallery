package app.exceptionhandler;

import app.exception.CardException;
import app.exception.GroupException;
import app.exception.PersonException;
import app.exception.TagException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerService {

    @ExceptionHandler(PersonException.class)
    public ResponseEntity<String> handler(PersonException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CardException.class)
    public ResponseEntity<String> handler(CardException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TagException.class)
    public ResponseEntity<String> handler(TagException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GroupException.class)
    public ResponseEntity<String> handler(GroupException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
