package com.abhi.tutorial.google.trees;

// https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3074/

import com.abhi.tutorial.model.TreeNode;

public class DiameterOfBinaryTree {

    int maxDia = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return maxDia;
    }

    private int maxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeftDepth = maxDiameter(root.left);
        int maxRightDepth = maxDiameter(root.right);

        maxDia = Math.max(maxDia, maxLeftDepth + maxRightDepth);

        return 1 + Math.max(maxLeftDepth, maxRightDepth);
    }
}
