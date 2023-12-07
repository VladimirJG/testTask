package com.example.testTask;

import com.example.testTask.Util.InputStringTestData;
import com.example.testTask.dao.InputStringsDAO;
import com.example.testTask.models.InputString;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.testTask.Util.InputStringTestData.ACTUAL_STRING;
import static com.example.testTask.Util.InputStringTestData.EMPTY_STRING;

@SpringBootTest
class TestTaskApplicationTests {



    @Test
    void actualStringInput() {
		Assertions.assertTrue(ACTUAL_STRING.length()>5);
    }
    @Test
    void emptyStringInput() {
        Assertions.assertEquals(0, EMPTY_STRING.length());
    }
}
