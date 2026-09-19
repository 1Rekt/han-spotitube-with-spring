package nl.han.aim.oose.dea.spotitubewithspring.controllers.exceptions;

import nl.han.aim.oose.dea.spotitubewithspring.services.exceptions.LoginCredentialsIncorrectException;
import nl.han.aim.oose.dea.spotitubewithspring.services.exceptions.TokenDoesntExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginCredentialsIncorrectException.class)
    public ResponseEntity handleLoginIncorrectException(LoginCredentialsIncorrectException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("Forbidden: " + ex.getMessage());
    }

    @ExceptionHandler(TokenDoesntExistException.class)
    public ResponseEntity handleTokenDoesntExistException(TokenDoesntExistException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Unauthorized: " + ex.getMessage());
    }

}
