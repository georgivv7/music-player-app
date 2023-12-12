package dev.georgi.musicplayerbackendnew.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception e) {

        ProblemDetail errorDetails = null;

        if(e instanceof JsonProcessingException) {
            errorDetails = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), e.getMessage());
            errorDetails.setProperty("Bad Request", "Not found");
        } else if(e instanceof RuntimeException) {
            errorDetails = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), e.getMessage());
            errorDetails.setProperty("Internal Server Error", "Internal Server Error");
        }

        return errorDetails;
    }
}
