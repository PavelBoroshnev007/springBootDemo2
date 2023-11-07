package ru.netology.springbootdemo2;

import ru.netology.springbootdemo2.services.InvalidCredentials;
import ru.netology.springbootdemo2.services.UnauthorizedUser;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleInvalidCredentialsException(InvalidCredentials ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String handleUnauthorizedUserException(UnauthorizedUser ex) {
        System.out.println(ex.getMessage()); // Печать сообщения в консоль
        return ex.getMessage();
    }
}
