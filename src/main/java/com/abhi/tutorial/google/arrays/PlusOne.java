package com.abhi.tutorial.google.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/explore/interview/card/google/59/array-and-strings/339/

public class PlusOne {
    public int[] plusOne(int[] digits) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = digits[digits.length - 1] + 1;
        int remainder = sum % 10;
        int carryOver = sum / 10;
        stack.push(remainder);
        for (int i = digits.length - 2; i >= 0 ; i--) {
            sum = digits[i] + carryOver;
            remainder = sum % 10;
            carryOver = sum / 10;
            stack.push(remainder);
        }
        if (carryOver != 0) {
            stack.push(carryOver);
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {9};
        int[] result = (new PlusOne()).plusOne(ints);
        for (int val : result) {
            System.out.println(val);
        }
    }
}
