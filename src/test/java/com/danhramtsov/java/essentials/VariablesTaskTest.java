package com.danhramtsov.java.essentials;

import org.junit.jupiter.api.*;

import java.io.*;
import java.util.regex.*;

import static org.junit.jupiter.api.Assertions.*;

class VariablesTaskTest {

    @Test
    void testOutputFormat() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        VariablesTask.main(new String[]{});

        String result = out.toString().trim();

        // Проверка наличия возраста (целое число)
        assertTrue(
                Pattern.compile("Age:\\s*\\d+").matcher(result).find(),
                "Вывод должен содержать 'Age: <число>'"
        );

        // Проверка наличия имени (любая непустая строка)
        assertTrue(
                Pattern.compile("Name:\\s*\\S+").matcher(result).find(),
                "Вывод должен содержать 'Name: <текст>'"
        );

        // Проверка константы DAYS_IN_WEEK
        assertTrue(
                result.contains("Days in week: 7"),
                "Вывод должен содержать 'Days in week: 7'"
        );
    }
}