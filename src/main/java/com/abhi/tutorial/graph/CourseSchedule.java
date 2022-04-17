package com.abhi.tutorial.graph;

// https://leetcode.com/problems/course-schedule/

import java.util.ArrayDeque;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }

        int[] inorder = new int[numCourses];

        for (int[] preq : prerequisites) {
            inorder[preq[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == 0) {
                queue.add(i);
            }
        }

        if (queue.size() == 0) {
            return false;
        }

        while(!queue.isEmpty()) {
            int course = queue.poll();
            for (int[] preq : prerequisites) {
                if (preq[1] == course) {
                    inorder[preq[0]] = inorder[preq[0]] - 1;
                    if (inorder[preq[0]] == 0) {
                        queue.add(preq[0]);
                    }
                }
            }
        }

        for(int in : inorder) {
            if (in != 0) {
                return false;
            }
        }
        return true;
    }
}
