package com.nagarro.exceptions.handlers;

import com.nagarro.exceptions.OrderCreationException;
import com.nagarro.exceptions.OrderInvalidException;
import com.nagarro.models.dto.responses.ErrorResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({OrderCreationException.class, OrderInvalidException.class})
    public ResponseEntity<ErrorResponseDTO> claimException(RuntimeException ex) {
        String errorMessage = ex.getMessage();
        log.error(errorMessage);
        return new ResponseEntity<>(new ErrorResponseDTO(errorMessage), HttpStatus.BAD_REQUEST);
    }
}
