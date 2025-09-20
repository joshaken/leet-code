package com.leetcode.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class N_aryTreeLevelOrderTraversal429 {
    public List<List<Integer>> levelOrder(Node root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            ArrayList<Integer> line = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.pollFirst();
                line.add(node.val);

                if (node.children != null) {
                    node.children.forEach(queue::addLast);
                }
            }
            res.add(line);

        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
