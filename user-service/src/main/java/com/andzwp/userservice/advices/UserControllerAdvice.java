package com.andzwp.userservice.advices;

import com.andzwp.userservice.dto.ErrorResponse;
import com.andzwp.userservice.exceptions.NoSuchUserException;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@ControllerAdvice(annotations = RestController.class)
public class UserControllerAdvice {

    @ExceptionHandler(NoSuchUserException.class)
    public ResponseEntity<ErrorResponse> handlerNoSuchUserException(@NonNull NoSuchUserException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(
                HttpStatus.NOT_FOUND.toString(),
                e.getMessage(),
                Collections.singletonList(e.getMessage())
        ));
    }

}
