package com.leetcode.sliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenation30 {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return res;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int windowLength = wordLength * wordCount;

        if (s.length() < windowLength) {
            return res;
        }
        HashMap<String, Integer> needMap = new HashMap<>();
        for (String word : words) {
            needMap.put(word, needMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            int count = 0;

            HashMap<String, Integer> window = new HashMap<>();
            while (right + wordLength <= s.length()) {
                String w = s.substring(right, right + wordLength);
                right = right + wordLength;

                if (!needMap.containsKey(w)) {
                    window.clear();
                    count = 0;
                    left = right;
                } else {
                    window.put(w, window.getOrDefault(w, 0) + 1);
                    count++;

                    while (window.get(w) > needMap.get(w)) {
                        String x = s.substring(left, left + wordLength);
                        window.put(x, window.get(x) - 1);
                        left = left + wordLength;
                        count--;
                    }

                    if (wordCount == count) {
                        res.add(left);

                        String u = s.substring(left, left + wordLength);
                        window.put(u, window.get(u) - 1);
                        left = left + wordLength;
                        count--;
                    }
                }
            }
        }
        return res;
    }
}
