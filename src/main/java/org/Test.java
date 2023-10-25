package org;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        //0->2->6->8，另外一条链表为1->3->5->7
//        ListNode listNode0 = new ListNode(0);
//        ListNode listNode1 = new ListNode(2);
//        listNode0.next = listNode1;
//        ListNode listNode2 = new ListNode(6);
//        listNode1.next = listNode2;
//        ListNode listNode3 = new ListNode(8);
//        listNode2.next = listNode3;
//
//        ListNode node0 = new ListNode(1);
//        ListNode node1 = new ListNode(3);
//        node0.next = node1;
//        ListNode node2 = new ListNode(5);
//        node1.next = node2;
//        ListNode node3 = new ListNode(7);
//        node2.next = node3;
//
//
//        ListNode node = mergeTwoLists(listNode0, node0);
//        System.out.println(node);
        TreeNode root = null;
    }

    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int num : nums) {
                ans = ans ^ num;
            }
        }
        return ans;
    }



    public static List<Integer> sol3(TreeNode root) {

        //使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
        //如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
        //如果遇到的节点为灰色，则将节点的值输出。
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int white = 0;
        int grey = 1;
        StackNode stackNode = new StackNode(white, root);
        Stack<StackNode> stack = new Stack<>();
        stack.push(stackNode);

        while (!stack.empty()) {
            StackNode cur = stack.pop();
            if (cur.node == null) {
                continue;
            }
            if (cur.color == white) {
                stack.push(new StackNode(white, cur.node.right));
                cur.color = grey;
                stack.push(cur);
                stack.push(new StackNode(white, cur.node.left));
            } else {
                list.add(cur.node.val);
            }
        }
        return list;
    }

    static class StackNode {
        int color;
        TreeNode node;

        public StackNode() {
        }

        public StackNode(int color, TreeNode node) {
            this.color = color;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        inOrder(list, root);

        return list;
    }

    public static void inOrder(List<Integer> list, TreeNode node) {

        if (node == null) return;
        inOrder(list, node.left);
        list.add(node.val);
        inOrder(list, node.right);

    }

//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null) {
//            return list2;
//        }
//        if (list2 == null) {
//            return list1;
//        }
//
//        if (list1.val < list2.val) {
//            list1.next = mergeTwoLists(list1.next, list2);
//            return list1;
//        } else {
//            list2.next = mergeTwoLists(list1, list2.next);
//            return list2;
//        }
//
//
//    }

//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//
//    }

    //Definition for a binary tree node.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
