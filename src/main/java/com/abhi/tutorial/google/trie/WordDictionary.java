package com.abhi.tutorial.google.trie;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/


// Use DFS - solution is not correct
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
        LetterNode search = root;
        Collection<LetterNode> possible = new HashSet<>();
        for (char ch : word.toCharArray()) {
            if (ch != '.') {
                if (!possible.isEmpty()) {
                    boolean found = false;
                    for (LetterNode node : possible) {
                        if (node.node.containsKey(ch)) {
                            search = node.node.get(ch);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        return false;
                    }
                    possible.clear();
                    continue;
                }
                if (!search.node.containsKey(ch)) {
                    return false;
                }
                search = search.node.get(ch);
            } else {
                if (search.isEnd) {
                    return false;
                }
                if (possible.isEmpty()) {
                    possible.addAll(search.node.values());
                } else {
                    Collection<LetterNode> next = new HashSet<>();
                    for (LetterNode node : possible) {
                        next.addAll(node.node.values());
                    }
                    possible.clear();
                    possible.addAll(next);
                }
            }
        }
        if (possible.isEmpty()) {
            return search.isEnd;
        }

        for (LetterNode node : possible) {
            if (node.isEnd) {
                return true;
            }
        }
        return false;
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
