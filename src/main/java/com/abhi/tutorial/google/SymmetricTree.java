package com.abhi.tutorial.google;

import com.abhi.tutorial.google.model.TreeNode;
import com.abhi.tutorial.google.tree.TreeBuilder;

import java.util.*;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        boolean isSymmetyric = true;
        if (root != null) {
            nodeQueue.offer(root);
            while (!nodeQueue.isEmpty()) {
                int queueSize = nodeQueue.size();
                List<Integer> elements = new ArrayList<>();
                for (int i = 0; i < queueSize; i++) {
                    TreeNode node = nodeQueue.poll();
                    elements.add(node.val);
                    if (node.left != null) {
                        nodeQueue.add(node.left);
                    }
                    if (node.right != null) {
                        nodeQueue.add(node.right);
                    }
                }
                isSymmetyric = isSymmetyric && checkIfSymmetric(elements);
                if (!isSymmetyric) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean checkIfSymmetric(List<Integer> elements) {
        int lo = 0;
        int hi = elements.size() - 1;
        while (lo <= hi) {
            if (!Objects.equals(elements.get(lo), elements.get(hi))) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] treeNodes = {1,2,2,3,4,4,3};
        TreeNode tree = (new TreeBuilder()).insertLevelOrder(treeNodes, null, 0);
        System.out.println((new SymmetricTree()).isSymmetric(tree));
    }
}
