package com.abhi.tutorial.bloomberg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int presentRow = 0;
        int presentCol = 0;
        boolean goRight = true;
        boolean goLeft = false;
        boolean goDown = false;
        boolean goUp = false;
        Set<String> visited = new HashSet<>();
        while (visited.size() < rows * cols) {
            String position = String.valueOf(presentRow) + presentCol;
            if (goRight) {
                if (presentCol >= cols || visited.contains(position)) {
                    goRight = false;
                    goDown = true;
                    presentRow++;
                    presentCol--;
                }
                else {
                    if (!visited.contains(position) && presentRow >= 0 && presentRow < rows && presentCol >= 0) {
                        visited.add(position);
                        result.add(matrix[presentRow][presentCol]);
                        presentCol++;
                    }
                    else {
                        goRight = false;
                        goDown = true;
                        presentRow++;
                    }
                }
                continue;
            }
            if (goDown) {
                if (presentRow >= rows || visited.contains(position)) {
                    goDown = false;
                    goLeft = true;
                    presentCol--;
                    presentRow--;
                }
                else {
                    if (!visited.contains(position) && presentRow >= 0 && presentCol >= 0 && presentCol < cols) {
                        visited.add(position);
                        result.add(matrix[presentRow][presentCol]);
                        presentRow++;
                    }
                    else {
                        goDown = false;
                        goLeft = true;
                        presentCol--;
                    }
                }
                continue;
            }
            if (goLeft) {
                if (presentCol < 0 || visited.contains(position)) {
                    goLeft = false;
                    goUp = true;
                    presentRow--;
                    presentCol++;
                }
                else {
                   if (!visited.contains(position) && presentRow >= 0 && presentRow < rows && presentCol < cols) {
                       visited.add(position);
                       result.add(matrix[presentRow][presentCol]);
                       presentCol--;
                   }
                   else {
                       goLeft = false;
                       goUp = true;
                       presentRow--;
                   }
                }
                continue;
            }
            if (presentRow < 0 || visited.contains(position)) {
                goUp = false;
                goRight = true;
                presentCol++;
                presentRow++;
            }
            else {
                if (!visited.contains(position) && presentRow < rows && presentCol >= 0 && presentCol < cols) {
                    visited.add(position);
                    result.add(matrix[presentRow][presentCol]);
                    presentRow--;
                }
                else {
                    goUp = false;
                    goRight = true;
                    presentCol++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" , ")));
    }
}
