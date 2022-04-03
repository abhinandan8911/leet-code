package com.abhi.tutorial.google.trees;


// https://leetcode.com/explore/featured/card/google/61/trees-and-graphs/3071/

import com.abhi.tutorial.model.TreeNode;

public class CountTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
