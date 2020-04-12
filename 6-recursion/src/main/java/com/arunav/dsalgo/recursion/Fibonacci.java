package com.arunav.dsalgo.recursion;

public class Fibonacci {

    public static void main(String[] args) {
        fibonacci(0, 1, 1000);
    }

    private static void fibonacci(int i, int j, int max) {
        if (j >= max)
            return;
        System.out.print(i + " " + j + " ");
        fibonacci(i + j, i + j + j, max);
    }
}
