package com.leetcode.sliding;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MaxNumOfVowels1456 {


    public int maxVowels(String s, int k) {
        int left = 0;
        int sum = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                sum++;
            }

            if (right - left + 1 > k) {
                c = s.charAt(right - k);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    sum--;
                }
                left++;
            }

            max = Math.max(sum, max);

        }
        return max;
    }

    public int maxVowels1(String s, int k) {
        Character[] v = {'a', 'e', 'i', 'o', 'u'};
        Set<Character> set = Arrays.stream(v).collect(Collectors.toSet());

        char[] charArray = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(charArray[i])) {
                sum++;
            }
        }

        int max = sum;
        for (int i = k; i < charArray.length; i++) {
            if (set.contains(charArray[i])) {
                sum++;
            }
            if (set.contains(charArray[i - k])) {
                sum--;
            }
            max = Math.max(max, sum);
        }
        return max;

    }
}
