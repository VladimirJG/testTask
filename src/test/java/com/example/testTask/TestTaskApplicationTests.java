package com.example.testTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.testTask.Util.InputStringTestData.ACTUAL_STRING;
import static com.example.testTask.Util.InputStringTestData.EMPTY_STRING;

@SpringBootTest
class TestTaskApplicationTests {


    @Test
    void actualStringInput() {
        Assertions.assertTrue(ACTUAL_STRING.length() > 5);
    }

    @Test
    void emptyStringInput() {
        Assertions.assertEquals(0, EMPTY_STRING.length());
    }
}
