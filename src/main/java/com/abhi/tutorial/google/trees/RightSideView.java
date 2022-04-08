package com.abhi.tutorial.google.trees;

import com.abhi.tutorial.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// https://leetcode.com/problems/binary-tree-right-side-view/

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int elem = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                elem = node.val;
                if (node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(elem);
        }
        return result;
    }
}
