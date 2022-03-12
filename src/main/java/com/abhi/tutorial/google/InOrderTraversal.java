package com.abhi.tutorial.google;

import com.abhi.tutorial.google.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/929/

public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        return traversal(root, new ArrayList<>());
    }

    private List<Integer> traversal(TreeNode root, ArrayList<Integer> values) {
        if (root != null) {
            traversal(root.getLeft(), values);
            values.add(root.getVal());
            traversal(root.getRight(), values);
        }
        return values;
    }
}
