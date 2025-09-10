package com.leetcode.twopointer;

import java.util.Arrays;

public class ReverseVowelsOfAString345 {
    public String reverseVowels(String s) {

        int left = 0;
        int right = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (left < right) {
            char l = charArray[left];
            if (!vowel(l)) {
                left++;
                continue;
            }
            char r = charArray[right];
            if (!vowel(r)) {
                right--;
                continue;
            }
            charArray[left] = r;
            charArray[right] = l;
            left++;
            right--;
        }
//        StringBuilder sb = new StringBuilder();
//        for (char c : charArray) {
//            sb.append(c);
//        }
        return new String(charArray);

    }

    private boolean vowel(char c) {
        if ('a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c
                || 'A' == c || 'E' == c || 'I' == c || 'O' == c || 'U' == c) {
            return true;
        }
        return false;
    }
}
