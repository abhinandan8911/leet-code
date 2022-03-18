package com.abhi.tutorial.google.tree;

import com.abhi.tutorial.google.model.TreeNode;

public class TreeBuilder {

    public TreeNode insertLevelOrder(int[] arr, TreeNode root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            TreeNode temp = new TreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

}
