package com.example.testTask.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class InputString {
    @NotEmpty(message = "Строка не может быть пустой")
    @Size(min = 5, message = "Строка не должна быть меньше 5 символов")
    @Pattern(regexp = "[a-z]+", message = "Ввод должен содержать строчные латинские буквы без пробелов. Пример: aaaaabcc")
    private String inputString;

    public InputString() {
    }

    public InputString(String inputString) {
        this.inputString = inputString;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }
}
