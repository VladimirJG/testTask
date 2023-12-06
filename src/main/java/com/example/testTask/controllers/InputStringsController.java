package com.example.testTask.controllers;

import com.example.testTask.dao.InputStringDAO;
import com.example.testTask.models.InputString;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/strings")
public class InputStringsController {
    private final InputStringDAO inputStringDAO;

    @Autowired
    public InputStringsController(InputStringDAO inputStringDAO) {
        this.inputStringDAO = inputStringDAO;
    }

    @GetMapping()
    public String input(@ModelAttribute("str") InputString inputString) {
        return "/strings/new";
    }

    @PostMapping()
    public String output(@ModelAttribute("str")  @Valid InputString inputString, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "/strings/new";

        model.addAttribute("list", inputStringDAO.getSortedValue(inputString));
        return "strings/output";
    }
}
