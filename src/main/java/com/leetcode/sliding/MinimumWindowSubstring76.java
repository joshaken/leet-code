package com.leetcode.sliding;

import java.util.HashMap;

public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        minWindow(s, t);
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.toCharArray().length; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }


        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int left = 0;
        int length = Integer.MAX_VALUE;

        int start = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (need.size() == valid) {
                if (right - left < length) {
                    length = right - left + 1;
                    start = left;
                }

                //这里直接移动左指针，所以需要一个start指针记录上次满足条件的左指针
                char x = s.charAt(left);
                left++;

                if (need.containsKey(x)) {
                    if (need.get(x).equals(window.get(x))) {
                        valid--;
                    }
                    window.put(x, window.get(x) - 1);
                }

            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }
}