package com.abhi.tutorial.bloomberg;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parenthesis {
    public static boolean isValid(String s) {
        boolean  isUnbalanced = false;
        char[] in = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char present : in) {
            if (present == '(' || present == '{' || present == '[') {
                stack.push(present);
            } else {
                if (present == ')' && stack.peekFirst() != null && stack.peekFirst() == '(') {
                    stack.pop();
                    continue;
                }
                if (present == '}' && stack.peekFirst() != null && stack.peekFirst() == '{') {
                    stack.pop();
                    continue;
                }
                if (present == ']' && stack.peekFirst() != null && stack.peekFirst() == '[') {
                    stack.pop();
                }
                else {
                    isUnbalanced = true;
                }
            }
        }
        return !isUnbalanced && stack.isEmpty();
    }

    public static void main(String[] args) {
        String in = ")(){}";
        System.out.println(isValid(in));
    }
}
