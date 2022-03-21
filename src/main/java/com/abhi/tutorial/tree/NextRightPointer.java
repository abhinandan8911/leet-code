package com.abhi.tutorial.tree;

import com.abhi.tutorial.tree.model.TreeNode;
import com.abhi.tutorial.tree.model.TreeBuilder;

import java.util.*;

// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/994/

public class NextRightPointer {


    public TreeNode connect(TreeNode root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                nodes.add(node);
            }
            if (nodes.size() > 0) {
                int count = 0;
                while (count <= nodes.size() - 2){
                    nodes.get(count).next = nodes.get(count+1);
                    count++;
                }
                nodes.get(nodes.size() - 1).next = null;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        int[] treeNodes = {1,2,3,4,5,6,7};
        TreeNode tree = (new TreeBuilder()).insertLevelOrder(treeNodes, null, 0);
        TreeNode calculated = (new NextRightPointer()).connect(tree);
    }

}
