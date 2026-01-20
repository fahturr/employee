package com.epicmed.employee.api.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e, HttpServletRequest request) {
        return generateResponseEntityError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<ErrorResponse> handleWebClientResponseException(WebClientResponseException e, HttpServletRequest request) {
        return generateResponseEntityError(e.getStatusCode(), e.getMessage());
    }

    @ExceptionHandler({WebClientRequestException.class, BusinessException.class, ValidationException.class})
    public ResponseEntity<ErrorResponse> handleWebClientRequestException(Exception e, HttpServletRequest request) {
        return generateResponseEntityError(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    private ResponseEntity<ErrorResponse> generateResponseEntityError(HttpStatusCode httpStatus, String message) {
        return generateResponseEntityError(HttpStatus.valueOf(httpStatus.value()), message);
    }

    private ResponseEntity<ErrorResponse> generateResponseEntityError(HttpStatus httpStatus, String message) {
        var errorResponse = ErrorResponse.builder()
            .timestamp(LocalDateTime.now())
            .status(httpStatus.value())
            .error(httpStatus.getReasonPhrase())
            .message(message)
            .build();

        return ResponseEntity
            .status(httpStatus.value())
            .body(errorResponse);
    }

}
