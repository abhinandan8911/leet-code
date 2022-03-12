package com.abhi.tutorial.google;

// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/

import com.abhi.tutorial.google.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preTravel(root, new ArrayList<>());
    }

    private List<Integer> preTravel(TreeNode root, List<Integer> values) {
        if (root == null) {
            return values;
        }
        values.add(root.getVal());
        preTravel(root.getLeft(), values);
        preTravel(root.getRight(), values);
        return values;
    }
}
