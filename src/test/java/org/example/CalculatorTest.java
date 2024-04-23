// B211202045
// Faruk Emre Ekşioğlu
// SWE 202 SOFTWARE VERIFICATION AND VALIDATION
// 2023-2024 SPRING SEMESTER
// Homework 1

package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @ParameterizedTest
    @DisplayName("Calculator.divide() parameterized test")
    @CsvSource({
            "10f, 2f, 5f",
            "10f, 4f, 2.5f",
            "12.5f, 2.5f, 5f",
            "10f, 2.5f, 4f",
            "12.5f, 5f, 2.5f",
            "12.5f, 0f, Illegal Argument Exception.",
    })
    void parameterizedTest(float p0, float p1, Object expected) {
        try {
            // if the expected value is a float, convert it to float and check if the result is equal
            expected = Float.parseFloat(expected.toString());
            assertEquals((float) expected, Calculator.divide(p0, p1));
        } catch (NumberFormatException ignored) {
            // check if the expected exception message is correct
            try {
                //noinspection ResultOfMethodCallIgnored
                Calculator.divide(p0, p1);
            } catch (Exception e) {
                assertEquals(expected, e.getMessage());
            }
        }
    }
}
