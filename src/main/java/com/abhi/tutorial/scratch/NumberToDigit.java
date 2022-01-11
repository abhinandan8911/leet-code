package com.abhi.tutorial.scratch;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberToDigit {
    public static int[] numberToDigit(int num) {
        Deque<Integer> numbers = new ArrayDeque<>();
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            numbers.push(digit);
        }
        int[] result = new int[numbers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = numbers.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = numberToDigit(123);
        for (int j : result) {
            System.out.println(j);
        }
    }
}
