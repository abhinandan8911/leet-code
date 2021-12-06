package com.abhi.tutorial;

import java.util.Stack;

public class Parenthesis {
    public static boolean isValid(String s) {
        boolean  isUnbalanced = false;
        char[] in = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char present : in) {
            if (present == '(' || present == '{' || present == '[') {
                stack.push(present);
            } else {
                if (present == ')' && !stack.empty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                if (present == '}' && !stack.empty() && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                if (present == ']' && !stack.empty() && stack.peek() == '[') {
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
