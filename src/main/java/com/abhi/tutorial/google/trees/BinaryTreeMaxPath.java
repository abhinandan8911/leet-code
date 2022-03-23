package com.abhi.tutorial.google.trees;

import com.abhi.tutorial.tree.model.TreeNode;


// https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3067/

public class BinaryTreeMaxPath {

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(maxSum(root.left), 0);
        int rightSum = Math.max(maxSum(root.right), 0);

        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}
