package com.example.testTask.util;

import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorsUtil {
    public static List<String> returnErrorsToClient(BindingResult bindingResult) {

        return bindingResult.getFieldErrors().stream().map(e -> e.getField() + " - " +
                e.getDefaultMessage() + "; " + LocalDateTime.now()).toList();
    }
}
