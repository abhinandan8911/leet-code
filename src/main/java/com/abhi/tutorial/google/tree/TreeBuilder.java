package com.abhi.tutorial.google.tree;

import com.abhi.tutorial.google.model.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TreeBuilder {

    private final List<Integer> nodes;

    public TreeBuilder(List<Integer> nodes) {
        this.nodes = nodes;
    }

//    public TreeNode buildTree() {
//        Deque<TreeNode> queue = new ArrayDeque<>();
//        for (Integer node : nodes) {
//            if (node != null) {
//                TreeNode treeNode = new TreeNode(node);
//                queue.offer(treeNode);
//            } else {
//                TreeNode nullNode = new TreeNode(Integer.MIN_VALUE);
//                queue.offer(nullNode);
//            }
//        }
//
//        TreeNode root = null;
//        if (!queue.isEmpty()) {
//            root = queue.getFirst();
//        }
//
//        TreeNode node = null;
//        while (!queue.isEmpty()) {
//            node = queue.remove();
//
//        }
//    }
}
