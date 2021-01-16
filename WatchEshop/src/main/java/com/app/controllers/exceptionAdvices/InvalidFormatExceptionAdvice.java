package com.app.controllers.exceptionAdvices;

import com.app.controllers.exceptions.ValidationException;
import com.app.database.loader.LoadDatabase;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class InvalidFormatExceptionAdvice {
    private static final Logger log = LoggerFactory.getLogger(InvalidFormatExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidFormatExceptions(InvalidFormatException ex) {
        log.error(ex.getMessage());
        return "Bad format : " + ex.getOriginalMessage();
    }
}
