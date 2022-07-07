package com.abhi.tutorial.google.binarysearch;

// https://leetcode.com/problems/search-a-2d-matrix/

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i = 0; i < rows; i++) {
            if (target <= matrix[i][cols - 1] && target >= matrix[i][0]) {
                int lo = 0;
                int hi = cols - 1;
                while(lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (target == matrix[i][mid]) {
                        return true;
                    } else if (target < matrix[i][mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
