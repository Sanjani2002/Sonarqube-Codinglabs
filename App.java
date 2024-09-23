package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, SonarQube and Jenkins Integration!");
        int result = addNumbers(10, 20);
        System.out.println("Result of addition: " + result);
    }

    public static int addNumbers(int a, int b) {
        return a + b;
    }
}
