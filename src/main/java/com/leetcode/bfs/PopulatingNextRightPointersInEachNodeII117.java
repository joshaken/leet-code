package com.leetcode.bfs;

import java.util.ArrayDeque;

public class PopulatingNextRightPointersInEachNodeII117 {
    public Node connect(Node root) {

        return root;
    }

    public Node connect1(Node root) {
        if (root == null) {
            return root;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            Node last = null;
            while (size > 0) {
                Node node = queue.removeFirst();
                if (last == null) {
                    last = node;
                } else {
                    last.next = node;
                    last = node;
                }
                if (last.left != null) {
                    queue.addLast(last.left);
                }
                if (last.right != null) {
                    queue.addLast(last.right);
                }
                size--;
            }
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

    }
}
