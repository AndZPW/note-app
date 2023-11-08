package com.andzwp.userservice.advices;

import com.andzwp.userservice.dto.ErrorResponse;
import com.andzwp.userservice.exceptions.NoSuchEntityException;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@ControllerAdvice(annotations = RestController.class)
public class UserControllerAdvice {

    @ExceptionHandler(NoSuchEntityException.class)
    public ResponseEntity<ErrorResponse> handlerNoSuchUserException(@NonNull NoSuchEntityException e) {
        var statusCode = HttpStatus.NOT_FOUND;

        var errorEntity = new ErrorResponse(
                statusCode.toString(),
                e.getMessage(),
                Collections.singletonList(e.getMessage())
        );

        return ResponseEntity.status(statusCode)
                .body(errorEntity);
    }



}
