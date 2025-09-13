package com.leetcode.twopointer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!Objects.equals(list.get(left), list.get(right))) {
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}
