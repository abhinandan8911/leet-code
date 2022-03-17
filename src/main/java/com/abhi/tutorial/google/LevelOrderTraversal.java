package com.abhi.tutorial.google;

import com.abhi.tutorial.google.model.TreeNode;

import java.util.*;

// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/931/

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            // start the current level
            levels.add(new ArrayList<>());

            // number of elements in the current level
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();

                // fulfill the current level
                levels.get(level).add(node.getVal());

                // add child nodes of the current level
                // in the queue for the next level
                if (node.getLeft() != null) queue.add(node.getLeft());
                if (node.getRight() != null) queue.add(node.getRight());
            }
            // go to next level
            level++;
        }
        return levels;
    }

}
