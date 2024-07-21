package com.juandiegodelacruz.bookingapi.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import com.juandiegodelacruz.bookingapi.dto.ErrorResponse;

@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorResponse handleHttpMessageNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
        logger.error(extractErrorMessage(ex));
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Bad Request", extractErrorMessage(ex));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        Map<String, List<String>> body = new HashMap<>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        List<String> errors = violations.stream()
                .map(violation -> getLastElement(violation.getPropertyPath().toString())  + ": " + violation.getMessage())
                .collect(Collectors.toList());
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Bad Request",errors.toString().replaceAll("\\[|\\]", ""));
    }

    private String extractErrorMessage(HttpMessageNotReadableException ex) {
        logger.info("EXTRA_ERROR_MESSAGE ");
        logger.info(ex.getMessage());
        Throwable rootCause = ex.getRootCause();
        if (rootCause instanceof MismatchedInputException) {
            MismatchedInputException mismatchedInputException = (MismatchedInputException) rootCause;
            return "Error at " + mismatchedInputException.getPath().stream()
                    .map(ref -> ref.getFieldName() != null ? ref.getFieldName() : ref.getIndex())
                    .reduce((first, second) -> first + "." + second)
                    .orElse("unknown");
        }
        return rootCause != null ? rootCause.getMessage() : ex.getMessage();
    }
    private static String getLastElement(String propertyPath) {
        if (propertyPath == null || propertyPath.isEmpty()) {
            return null;
        }

        String[] parts = propertyPath.split("\\.");
        return parts.length > 0 ? parts[parts.length - 1] : null;
    }

}