package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return sum(d) + multiply(d) + minus(d) + divide(d);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println("resultSum = " + result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println("rslMultiply = " + rsl);
        int rslMinus = Calculator.minus(7);
        System.out.println("rslMinus = " + rslMinus);
        int rslDivide = calculator.divide(25);
        System.out.println("rslDivide = " + rslDivide);
        int rslSum = calculator.sumAllOperation(10);
        System.out.println("rslSum = " + rslSum);
    }
}
