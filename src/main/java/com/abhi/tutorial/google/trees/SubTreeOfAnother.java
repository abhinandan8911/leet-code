package com.abhi.tutorial.google.trees;


// https://leetcode.com/problems/subtree-of-another-tree/

import com.abhi.tutorial.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SubTreeOfAnother {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isTreeSame(node, subRoot)) {
                return true;
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }

    private boolean isTreeSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            return p.val == q.val && isTreeSame(p.left, q.left) && isTreeSame(p.right, q.right);
        } else {
            return false;
        }
    }

}
