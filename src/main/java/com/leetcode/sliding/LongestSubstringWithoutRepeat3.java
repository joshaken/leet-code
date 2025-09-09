package com.leetcode.sliding;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat3 {

    public static void main(String[] args) {
        String s = " ";
        lengthOfLongestSubstring(s);
    }


    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int sum = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            sum = Math.max(sum, right - left + 1);

        }

        return sum;
    }
    public static int lengthOfLongestSubstring1(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int sum = 1;
        int max = 0;
        int left = 0;
        for (int right = 1; right < s.length(); right++) {
            char c = s.charAt(right);
            boolean flag = false;
            for (int i = right -1; i >= left; i--) {
                if (s.charAt(i) == c) {
                    left = i + 1;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                sum = right - left + 1;
            } else {
                sum++;
            }

            max = Math.max(sum, max);

        }

        return Math.max(sum, max);
    }
}
