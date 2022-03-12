package com.abhi.tutorial.google.tree;

import com.abhi.tutorial.google.model.TreeNode;

import java.util.List;

public class TreeBuilder {

    private final List<Integer> nodes;

    public TreeBuilder(List<Integer> nodes) {
        this.nodes = nodes;
    }

    public TreeNode buildTree() {
        TreeNode root = null;
        if (nodes.size() == 0) {
            return root;
        } else {
            root = new TreeNode(nodes.get(0));
        }
        TreeNode travel = root;
        int nodeCounter = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) != null) {
                int rightIndex = 2 * nodeCounter + 1;
                int leftIndex = 2 * nodeCounter + 2;
                if (nodes.get(rightIndex) != null) {
                    travel.setRight(new TreeNode(nodes.get(rightIndex)));
                }
                if (nodes.get(leftIndex) != null) {
                    travel.setLeft(new TreeNode(nodes.get(leftIndex)));
                }
                nodeCounter++;
            }
        }
        return root;
    }
}
