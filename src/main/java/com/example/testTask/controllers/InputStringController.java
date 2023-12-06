package com.example.testTask.controllers;

import com.example.testTask.dao.InputStringDAO;
import com.example.testTask.models.InputString;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/string")
public class InputStringController {
    private final InputStringDAO inputStringDAO;

    @Autowired
    public InputStringController(InputStringDAO inputStringDAO) {
        this.inputStringDAO = inputStringDAO;
    }

    @GetMapping("/input")
    public String input(@ModelAttribute("str") InputString inputString) {
        return "string/input";
    }

    @PostMapping("/output")
    public String output(@ModelAttribute("str") @Valid InputString inputString, BindingResult bindingResult, Model model) {
       /* if (bindingResult.hasErrors())
            return "string/input";*/

        model.addAttribute("list", inputStringDAO.getSortedValue(inputString));
        return "string/output";
    }
}
