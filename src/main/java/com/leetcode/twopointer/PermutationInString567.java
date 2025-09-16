package com.leetcode.twopointer;

import java.util.HashMap;

public class PermutationInString567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int let = s1.length();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> exist = new HashMap<>();
        for (int i = 0; i < let; i++) {
            char c = s2.charAt(i);
            exist.put(c, exist.getOrDefault(c, 0) + 1);
        }
        if (need.equals(exist)) {
            return true;
        }

        for (int i = let; i < s2.length(); i++) {
            char c = s2.charAt(i);
            exist.put(c, exist.getOrDefault(c, 0) + 1);

            char l = s2.charAt(i - let);
            if (exist.get(l) == 1) {
                exist.remove(l);
            } else {
                exist.put(l, exist.get(l) - 1);
            }

            if (exist.equals(need)) {
                return true;
            }

        }
        return false;

    }
}
