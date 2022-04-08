package com.abhi.tutorial.tree;


// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/


// This is for non BST
import com.abhi.tutorial.model.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (isTreeParent(root, p) && isTreeParent(root, q)) {
            if (root.val == p.val || root.val == q.val) {
                return root;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (isTreeParent(left, p) && isTreeParent(left, q)) {
                return lowestCommonAncestor(left, p, q);
            }
            if (isTreeParent(right, p) && isTreeParent(right, q)) {
                return lowestCommonAncestor(right, p, q);
            }
        }
        return root;
    }

    private boolean isTreeParent(TreeNode root, TreeNode child) {
        if (root == null) {
            return false;
        }

        if (root.val == child.val) {
            return true;
        }

        return isTreeParent(root.left, child) || isTreeParent(root.right, child);
    }
}
