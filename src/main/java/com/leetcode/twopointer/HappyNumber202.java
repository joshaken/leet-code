package com.leetcode.twopointer;

public class HappyNumber202 {
    public static void main(String[] args) {
        isHappy(19);
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = next(n);
        while (fast != 1 && slow != fast) {
            slow = next(slow);
            fast = next(next(fast));
        }
        return fast == 1;
    }

    private static int next(int n) {
        int sum = 0;
        while (n > 0) {
            int i = n % 10;
            sum = sum + i * i;
            n = n / 10;
        }

        return sum;
    }
}
