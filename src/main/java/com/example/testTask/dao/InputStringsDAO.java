package com.example.testTask.dao;

import com.example.testTask.models.InputString;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class InputStringsDAO {

    public List<String> getSortedValue(InputString inputString) {
        String s = inputString.getInputString();
        Map<Character, Integer> charOut = new LinkedHashMap<>();
        IntStream.range(0, s.length()).forEach(i -> {
            char c = s.charAt(i);
            charOut.put(c, charOut.getOrDefault(c, 0) + 1);
        });
        return charOut.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> entry.getKey() + " : " + entry.getValue()).collect(Collectors.toList());
    }
}
