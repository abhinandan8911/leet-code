package com.abhi.tutorial.tree;

// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/535/

import com.abhi.tutorial.model.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        return Math.max(maxLeftDepth, maxRightDepth) + 1;
    }

}
