package com.abhi.tutorial.recursion;


// https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/

public class ReverseString {
    public char[] reverseString(char[] s) {
        printReverse(0, s.length - 1, s);
        return s;
    }

    private void printReverse(int lo, int hi, char[] s) {
        if (s == null || s.length == 0 || lo > hi) {
            return;
        }
        char temp = s[lo];
        s[lo] = s[hi];
        s[hi] = temp;
        printReverse(lo + 1, hi - 1, s);
    }

    public static void main(String[] args) {
        char[] input = {'c', 'a', 't'};
        char[] result = (new ReverseString()).reverseString(input);
        for (char ch : result) {
            System.out.print(ch);
        }
    }
}
