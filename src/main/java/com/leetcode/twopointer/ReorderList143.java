package com.leetcode.twopointer;

public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseList = slow.next;
        slow.next = null;

        ListNode f = head;
        ListNode t = reverseList;
        while (f != null) {
            ListNode temp = f.next;
            if (t != null) {
                ListNode sec = t.next;
                f.next = t;
                t.next = temp;
                t = sec;
            }

            f = temp;
        }

    }

    private ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;

            cur.next = prev;
            prev = cur;
            cur = temp;

        }
        return prev;
    }
}
