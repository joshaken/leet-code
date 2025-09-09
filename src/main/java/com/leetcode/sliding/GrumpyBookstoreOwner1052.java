package com.leetcode.sliding;

public class GrumpyBookstoreOwner1052 {
    public static void main(String[] args) {
        int[] cs = {1,0,1,2,1,1,7,5};
        int[] gr = {0,1,0,1,0,1,0,1};
        maxSatisfied(cs, gr, 3);
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 1 && i >= minutes) {
                continue;
            }
            sum += customers[i];
        }
        int max = sum;

        for (int i = minutes; i < grumpy.length; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                sum -= customers[i - minutes];
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
