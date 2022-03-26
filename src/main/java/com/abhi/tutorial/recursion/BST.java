package com.abhi.tutorial.recursion;


// https://leetcode.com/explore/learn/card/recursion-i/251/scenario-i-recurrence-relation/3233/

import com.abhi.tutorial.model.TreeNode;

public class BST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
