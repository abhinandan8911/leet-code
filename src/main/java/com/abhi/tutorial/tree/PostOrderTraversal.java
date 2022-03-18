package com.abhi.tutorial.tree;

import com.abhi.tutorial.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        return traversal(root, new ArrayList<>());
    }

    private List<Integer> traversal(TreeNode root, ArrayList<Integer> integers) {
        if (root != null) {
            traversal(root.left, integers);
            traversal(root.right, integers);
            integers.add(root.val);
        }
        return integers;
    }
}
