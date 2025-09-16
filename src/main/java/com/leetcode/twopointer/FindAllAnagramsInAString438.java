package com.leetcode.twopointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAllAnagramsInAString438 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        findAnagrams(s, p);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int letterLen = p.length();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> exist = new HashMap<>();

        for (int i = 0; i < letterLen; i++) {
            char c = s.charAt(i);
            exist.put(c, exist.getOrDefault(c, 0) + 1);
        }

        if (need.equals(exist)) {
            res.add(0);
        }

        for (int right = letterLen; right < s.length(); right++) {

            char r = s.charAt(right);
            exist.put(r, exist.getOrDefault(r, 0) + 1);

            char l = s.charAt(right - letterLen);
            if (exist.get(l) == 1) {
                exist.remove(l);
            } else {
                exist.put(l, exist.get(l) - 1);
            }

            if (need.equals(exist)) {
                res.add(right - letterLen + 1);
            }
        }
        return res;

    }
}
