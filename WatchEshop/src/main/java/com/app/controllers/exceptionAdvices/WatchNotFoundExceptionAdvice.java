package com.app.controllers.exceptionAdvices;


import com.app.controllers.exceptions.WatchNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WatchNotFoundExceptionAdvice {

    private static final Logger log = LoggerFactory.getLogger(WatchNotFoundExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(WatchNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String watchNotFoundHandler(WatchNotFoundException ex) {
        log.error(ex.getMessage());

        return ex.getMessage();
    }
}
