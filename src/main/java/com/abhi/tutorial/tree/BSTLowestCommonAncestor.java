package com.abhi.tutorial.tree;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

import com.abhi.tutorial.model.TreeNode;

public class BSTLowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
