package com.demo.appointments.exception;

import com.demo.appointments.dto.ErrorRs;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorRs> handleCommonExceptions(BadRequestException exception) {

        return ResponseEntity.badRequest().body(new ErrorRs(exception));
    }
}
