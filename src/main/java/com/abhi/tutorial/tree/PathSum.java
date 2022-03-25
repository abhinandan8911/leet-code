package com.abhi.tutorial.tree;

import com.abhi.tutorial.model.TreeNode;


// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root != null) {
            return isSumTrue(root, targetSum, 0);
        } else {
            return false;
        }
    }

    private boolean isSumTrue(TreeNode root, int targetSum, int runningSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return (runningSum + root.val) == targetSum;
        }

        boolean leftSum = isSumTrue(root.left, targetSum, runningSum + root.val);
        boolean rightSum = isSumTrue(root.right, targetSum, runningSum + root.val);
        return leftSum || rightSum;
    }
}
