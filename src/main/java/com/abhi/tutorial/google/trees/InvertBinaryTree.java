package com.abhi.tutorial.google.trees;


// https://leetcode.com/problems/invert-binary-tree/

import com.abhi.tutorial.model.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

}
