package com.app.controllers.exceptionAdvices;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class JsonMappingExceptionAdvice {

    private static final Logger log = LoggerFactory.getLogger(JsonMappingExceptionAdvice.class);

    @ResponseBody
    @ExceptionHandler(JsonMappingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleJsonMappingException(JsonMappingException ex) {
        log.error(ex.getMessage());
        return "Base64 format error: " + ex.getOriginalMessage();
    }
}
