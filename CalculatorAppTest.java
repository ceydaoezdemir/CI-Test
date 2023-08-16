package com.myproject;
import com.myproject.CalculatorApp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.Assert.assertEquals;

public class CalculatorAppTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void testCalculatorAppAddition() {
        String input = "5\n3\n+\n";
        String expectedOutput = "Enter the first number:\n" +
                               "Enter the second number:\n" +
                               "Select an operation (+, -, *, /):\n" +
                               "Result: 8\n";

        provideInput(input);
        CalculatorApp.main(new String[]{});

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void testCalculatorAppSubtraction() {
        String input = "7\n3\n-\n";
        String expectedOutput = "Enter the first number:\n" +
                               "Enter the second number:\n" +
                               "Select an operation (+, -, *, /):\n" +
                               "Result: 4\n";

        provideInput(input);
        CalculatorApp.main(new String[]{});

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void testCalculatorAppMultiplication() {
        String input = "6\n4\n*\n";
        String expectedOutput = "Enter the first number:\n" +
                               "Enter the second number:\n" +
                               "Select an operation (+, -, *, /):\n" +
                               "Result: 24\n";

        provideInput(input);
        CalculatorApp.main(new String[]{});

        assertEquals(expectedOutput, getOutput());
    }

    @Test
    public void testCalculatorAppDivision() {
        String input = "10\n2\n/\n";
        String expectedOutput = "Enter the first number:\n" +
                               "Enter the second number:\n" +
                               "Select an operation (+, -, *, /):\n" +
                               "Result: 5\n";

        provideInput(input);
        com.myproject.CalculatorApp.main(new String[]{});

        assertEquals(expectedOutput, getOutput());
    }

    private void provideInput(String data) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }

    private String getOutput() {
        return outputStream.toString();
    }
}
