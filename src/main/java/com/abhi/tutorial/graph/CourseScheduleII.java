package com.abhi.tutorial.graph;

// https://leetcode.com/explore/featured/card/graph/623/kahns-algorithm-for-topological-sorting/3868/

import java.util.ArrayDeque;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = i;
        }
        if (prerequisites == null || prerequisites.length == 0) {
            return res;
        }
        if (numCourses == 0) {
            return new int[0];
        }

        int[] inorder = new int[numCourses];
        for(int[] preq : prerequisites) {
            inorder[preq[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < inorder.length; i++) {
            if (inorder[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.size() == 0) {
            return new int[0];
        }

        int index = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            res[index++] = course;
            for (int[] preq : prerequisites) {
                if (preq[1] == course) {
                    inorder[preq[0]]--;
                    if (inorder[preq[0]] == 0) {
                        queue.add(preq[0]);
                    }
                }
            }
        }

        for (int in : inorder) {
            if (in != 0) {
                return new int[0];
            }
        }

        return res;
    }
}
