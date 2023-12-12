package com.example.authserver.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleSecurityException(Exception ex) {

        ProblemDetail errorDetail;

        if(ex instanceof AccessDeniedException) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "Not Authorized");
        }
        if(ex instanceof BadCredentialsException){
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "Authentication Failed");
        }
        if(ex instanceof SignatureException) {
            errorDetail =ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "JWT Signature not valid");
        }
        if(ex instanceof ExpiredJwtException) {
            errorDetail =ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "JWT Token already expired");
        }
        if(ex instanceof HttpClientErrorException.BadRequest) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "Bad Request");
        }
        if(ex instanceof  HttpClientErrorException.NotFound) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "Not Found");
        }
        if(ex instanceof  HttpClientErrorException.Forbidden) {
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "Forbidden");
        }else{
            errorDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
            errorDetail.setProperty("access_denied_reason", "Internal Server Error");
        }

        return errorDetail;
    }
}
