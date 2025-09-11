package com.leetcode.twopointer;

public class LinkedListCycleII142 {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        //链表 非环部分长度 = a
        //环的入口到相遇点的距离 = b
        //环的总长度 = c
        //那么：
        //slow 走过的总路程 = a + b
        //fast 走过的总路程 = a + b + k*c （其中 k 是 fast 多绕的圈数）

        //2(a + b) = a + b + k*c
        //=> a + b = k*c
        //=> a = k*c - b
        //从 head 出发走 a 步能到环入口。
        //从相遇点再走 c - b 步，也正好能到环入口（因为环长是 c，相遇点到入口是 c - b）。
        //而我们刚才算出来 a = k*c - b，这和 (c - b) 同余（模 c），所以它们落在同一个位置
        //为什么 fast 也要一起走？
        //把 fast 放回头，从 head 开始走 a 步就能到环入口。
        //把 slow 留在相遇点，从相遇点走 (c - b) 步也能到环入口。
        //因为 a ≡ c - b (mod c)，所以 它们会同时到达环入口。
        //因此必须让两个指针一起走一步一步，否则它们不会在环入口相遇。
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
