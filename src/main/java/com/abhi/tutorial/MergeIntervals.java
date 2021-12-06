package com.abhi.tutorial;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int count = 0;
        int[][] tempMerged = new int[intervals.length][];
        Set<Integer> checked = new HashSet<>();
        for (int i = 0; i < intervals.length;) {
            boolean merged = false;
            for (int j = i + 1; j < intervals.length && !checked.contains(j); j++) {
                if (intervals[j][0] <= intervals[i][1]) {
                    int[] temp = new int[2];
                    temp[0] = intervals[i][0];
                    if (intervals[j][1] > intervals[i][1]) {
                        temp[1] = intervals[j][1];
                    }
                    else {
                        temp[1] = intervals[i][1];
                    }
//                    tempMerged[count++] = temp;
                    intervals[i] = temp;
                    merged = true;
                    checked.add(j);
                }
            }
            if (!merged) {
                tempMerged[count++] = intervals[i];
                i++;
            }
        }
        int[][] merged = new int[count][];
        System.arraycopy(tempMerged, 0, merged, 0, count);
        return merged;
    }

    public static void main(String[] args) {
        int[][] input = {{1,3},{15,18},{8,10}, {2,6}};
        int[][] out = merge(input);
        Arrays.stream(out).forEach(item -> System.out.println(item[0] + " , " + item[1]));
    }
}
