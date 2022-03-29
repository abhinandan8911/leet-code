package com.abhi.tutorial.google.arrays.trees;

import java.util.*;

// https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3068/

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        words.remove(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (node != null) {
                    if (node.equals(endWord)) {
                        return level;
                    }
                    Set<String> neig = new HashSet<>();
                    for (String word : words) {
                        if (differByOneChar(node, word)) {
                            queue.add(word);
                            neig.add(word);
                        }
                    }
                    words.removeAll(neig);
                    neig.clear();
                }
            }
        }
        return 0;
    }

    private boolean differByOneChar(String first, String second) {
        if (first.equals(second)) {
            return false;
        }
        int count = 0;
        char[] arr = second.toCharArray();
        for (char ch : arr) {
            if (first.indexOf(ch) == -1) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("most","mist","miss","lost","fist","fish");
        System.out.println((new WordLadder()).ladderLength("lost", "miss", list));
    }
}
