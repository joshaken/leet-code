package com.leetcode.twopointer;

public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null && slow != fast) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow == fast;
    }
}
