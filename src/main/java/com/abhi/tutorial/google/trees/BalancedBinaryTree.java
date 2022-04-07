package com.abhi.tutorial.google.trees;

import com.abhi.tutorial.model.TreeNode;

// https://leetcode.com/problems/balanced-binary-tree/

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(heightOf(root.left) - heightOf(root.right)) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int heightOf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = heightOf(root.left);
        int right = heightOf(root.right);
        return 1 + Math.max(left, right);
    }
}
