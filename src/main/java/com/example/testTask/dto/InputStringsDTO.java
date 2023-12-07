package com.example.testTask.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class InputStringsDTO {
    @NotEmpty(message = "Строка не может быть пустой")
    @Size(min = 5, message = "Строка не должна быть меньше 5 символов")
    @Pattern(regexp = "[a-z]\\w+", message = "Ввод должен содержать строчные латинские буквы без пробелов. Пример: aaaaabcc")
    private String inputString;


    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
}
