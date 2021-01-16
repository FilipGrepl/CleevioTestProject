package com.app.controllers.validators;

import com.app.database.entities.Watch;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class WatchValidator {
    public void validate(Watch watch, Errors errors) {
        if (watch.getFountain() == null || watch.getFountain().length == 0) {
            errors.rejectValue("fountain", null, "Fountain parameter is mandatory");
        }
        else if (!Base64.isBase64(Base64.encodeBase64String(watch.getFountain()))) {
            errors.rejectValue("fountain", null,"Fountain is not in valid Base64 format. ");
        }
    }
}
