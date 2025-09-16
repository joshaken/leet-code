package com.leetcode.dp;

public class FibonacciNumber509 {
    public int fib(int n) {

        if (n <= 1) {
            return n;
        }

        int f1 = 1;
        int f0 = 0;

        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = f1 + f0;
            f0 = f1;
            f1 = f;
        }

        return f;

    }
}
