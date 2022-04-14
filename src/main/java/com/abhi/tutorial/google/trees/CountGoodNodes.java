package com.abhi.tutorial.google.trees;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

import com.abhi.tutorial.model.TreeNode;

public class CountGoodNodes {

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return count(root, root.val);
    }

    private int count(TreeNode root, int value) {
        if (root == null) {
            return 0;
        }
        return (root.val >= value)
                ? 1 + count(root.left, root.val) + count(root.right, root.val)
                : count(root.left, value) + count(root.right, value);
    }
}
