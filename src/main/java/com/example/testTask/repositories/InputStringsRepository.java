package com.example.testTask.repositories;

import com.example.testTask.models.InputString;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InputStringsRepository {
    List<String> getSortedValue(InputString inputString);
}
