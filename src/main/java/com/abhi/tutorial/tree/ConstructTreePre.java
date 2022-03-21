package com.abhi.tutorial.tree;

import com.abhi.tutorial.tree.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/943/

public class ConstructTreePre {
    int preIndex;
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        preIndex = 0;
        int index = 0;
        for (int val : inorder) {
            inOrderMap.put(val, index++);
        }
        return buildTreeHelper(0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIndex]);
        int rootIndex = inOrderMap.get(preorder[preIndex]);
        preIndex++;
        root.left = buildTreeHelper(lo, rootIndex - 1);
        root.right = buildTreeHelper(rootIndex + 1, hi);
        return root;
    }
}
