package com.abhi.tutorial.google.trie;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/


// Use DFS
import java.util.*;

public class WordDictionary {

    LetterNode root = null;

    public WordDictionary() {
        root = new LetterNode();
    }

    public void addWord(String word) {
        LetterNode temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.node.containsKey(ch)) {
                temp.node.put(ch, new LetterNode());
            }
            temp = temp.node.get(ch);
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        return searchInRoot(word, root);
    }

    private boolean searchInRoot(String word, LetterNode root) {
        LetterNode search = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (LetterNode node :search.node.values()) {
                    if (searchInRoot(word.substring(i + 1), node)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!search.node.containsKey(ch)) {
                    return false;
                }
                search = search.node.get(ch);
            }
        }
        return search.isEnd;
    }

    public static class LetterNode {
        Map<Character, LetterNode> node = new HashMap<>();
        boolean isEnd;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search("aa"));
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".a"));
        System.out.println(wordDictionary.search("a."));
    }
}
