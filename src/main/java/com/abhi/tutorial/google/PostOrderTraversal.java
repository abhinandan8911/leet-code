package com.abhi.tutorial.google;

import com.abhi.tutorial.google.model.TreeNode;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        return traversal(root, new ArrayList<>());
    }

    private List<Integer> traversal(TreeNode root, ArrayList<Integer> integers) {
        if (root != null) {
            traversal(root.getLeft(), integers);
            traversal(root.getRight(), integers);
            integers.add(root.getVal());
        }
        return integers;
    }
}
