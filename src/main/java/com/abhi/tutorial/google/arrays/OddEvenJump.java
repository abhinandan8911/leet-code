package com.abhi.tutorial.google.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OddEvenJump {

    public int oddEvenJumps(int[] arr) {
        int target = arr.length - 1;
        int count = 0;
        for (int i = 0; i <= target; i++) {
            int index = i;
            int jumps = 1;
            while (index <= target) {
                if ((jumps) % 2 == 0) {
                    List<int[]> possible = new ArrayList<>();
                    int n = index + 1;
                    while (n <= target) {
                        if (arr[index] >= arr[n]) {
                            possible.add(new int[]{arr[n], n});
                        }
                        n++;
                    }
                    if (possible.size() == 0) {
                        break;
                    }
                    possible.sort((a, b) -> {
                        int val = Integer.compare(a[0], b[0]);
                        if (val != 0) {
                            return val;
                        }
                        return Integer.compare(b[1], a[1]);
                    });
                    index = possible.get(possible.size() - 1)[1];
                    jumps++;
                } else {
                    List<int[]> possible = new ArrayList<>();
                    int n = index + 1;
                    while (n <= target) {
                        if (arr[index] <= arr[n]) {
                            possible.add(new int[]{arr[n], n});
                        }
                        n++;
                    }
                    if (possible.size() == 0) {
                        break;
                    }
                    possible.sort(Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
                    index = possible.get(0)[1];
                    jumps++;
                }
            }
            if (index == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10,13,12,14,15};

        OddEvenJump obj = new OddEvenJump();
        System.out.println(obj.oddEvenJumps(arr));
    }
}
