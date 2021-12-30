package com.abhi.tutorial.bloomberg;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {
    public static int compress(char[] chars) {
        int len = 0;
        int arrayLen = chars.length;
        char[] temp = new char[arrayLen];
        for (int i = 0, j = 0; i < arrayLen && j < arrayLen; ) {
            int rep = 1;
            char present = chars[i];
            while(++i < arrayLen && chars[i] == present) {
                rep++;
            }
            temp[j] = present;
            j++;
            if (rep > 1) {
                if (rep >= 10) {
                    int mul = rep;
                    List<Integer> nums = new ArrayList<>();
                    while (mul != 0) {
                        nums.add(mul % 10);
                        mul = mul / 10;
                    }
                    for (int k = nums.size() - 1; k >= 0 && j < arrayLen; k--) {
                        temp[j] = String.valueOf(nums.get(k)).charAt(0);
                        j++;
                    }
                }
                else {
                    temp[j] = String.valueOf(rep).charAt(0);
                    j++;
                }
            }
            len = j;
        }

        for (int i = 0; i < len; i++) {
            chars[i] = temp[i];
        }
        return len;
    }

    public static void main(String[] args) {
        char[] input = {'o','o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o'};
        int ret = compress(input);
        System.out.println(ret);
        for (char c : input) {
            System.out.println(c);
        }
    }
}
