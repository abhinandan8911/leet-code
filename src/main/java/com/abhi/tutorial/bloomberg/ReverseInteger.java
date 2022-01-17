package com.abhi.tutorial.bloomberg;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseInteger {
    public static int reverse(int x) {
        boolean positive = true;
        if (x < 0) {
            positive = false;
            x = x * -1;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        while (x > 0) {
            deque.offer(x % 10);
            x = x / 10;
        }
        String number = "";
        while (!deque.isEmpty()) {
            number = number + deque.poll();
        }
        double max = Math.pow(2.0, 32);

        int result = positive ? Integer.parseInt(number) : Integer.parseInt(number) * -1;

        if (result >= -1 * max && result < max - 1) {
            return result;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
