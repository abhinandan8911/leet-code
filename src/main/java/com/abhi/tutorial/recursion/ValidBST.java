package com.abhi.tutorial.recursion;


// https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2874/

import com.abhi.tutorial.model.TreeNode;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isSubTreeLesser(root.left, root.val) && isSubTreeGreater(root.right, root.val)
        && isValidBST(root.left) && isValidBST(root.right)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSubTreeLesser(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val < val && isSubTreeLesser(root.left, val) && isSubTreeLesser(root.right, val)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSubTreeGreater(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val > val && isSubTreeGreater(root.left, val) && isSubTreeGreater(root.right, val)) {
            return true;
        } else {
            return false;
        }
    }
}
