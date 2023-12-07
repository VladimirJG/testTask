package com.example.testTask.controllers;

import com.example.testTask.Services.InputStringsService;
import com.example.testTask.dao.InputStringsDAO;
import com.example.testTask.dto.InputStringsDTO;
import com.example.testTask.models.InputString;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.testTask.util.ErrorsUtil.returnErrorsToClient;

@Controller
@RequestMapping("/strings")
public class InputStringsController {
    private final InputStringsDAO inputStringsDAO;
    private final InputStringsService inputStringsService;
    private final ModelMapper modelMapper;

    @Autowired
    public InputStringsController(InputStringsDAO inputStringsDAO, InputStringsService inputStringsService, ModelMapper modelMapper) {
        this.inputStringsDAO = inputStringsDAO;
        this.inputStringsService = inputStringsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public String input(@ModelAttribute("str") InputString inputString) {
        return "/strings/new";
    }

    @PostMapping()
    public String output(@ModelAttribute("str") @Valid InputString inputString,
                         BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "/strings/new";

        model.addAttribute("list", inputStringsDAO.getSortedValue(inputString));
        return "strings/output";
    }

    @GetMapping("/dto")
    public String inputDTO(@ModelAttribute("strDTO") InputStringsDTO dto) {
        return "/strings/dto";
    }

    @ResponseBody()
    @PostMapping("/dto")
    public List<String> getListValues(@ModelAttribute("strDTO") @Valid InputStringsDTO dto,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return returnErrorsToClient(bindingResult);
        } else {
            InputString inputString = convertToInputString(dto);
            return inputStringsService.getSortedValue(inputString);
        }
    }

    private InputString convertToInputString(InputStringsDTO inputStringsDTO) {
        return modelMapper.map(inputStringsDTO, InputString.class);
    }
}
