package com.myproject;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Enter the first number:");
        int num1 = scanner.nextInt();

        System.out.println("Enter the second number:");
        int num2 = scanner.nextInt();

        System.out.println("Select an operation (+, -, *, /):");
        char operation = scanner.next().charAt(0);

        int result = 0;
        switch (operation) {
            case '+':
                result = calculator.add(num1, num2);
                break;
            case '-':
                result = calculator.subtract(num1, num2);
                break;
            case '*':
                result = calculator.multiply(num1, num2);
                break;
            case '/':
                try {
                    result = calculator.divide(num1, num2);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("Invalid operation.");
                return;
        }

        System.out.println("Result: " + result);
    }
}
