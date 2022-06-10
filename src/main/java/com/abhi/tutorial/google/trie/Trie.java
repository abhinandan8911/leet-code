package com.abhi.tutorial.google.trie;

import java.util.HashMap;
import java.util.Map;


// https://leetcode.com/problems/implement-trie-prefix-tree/submissions/

public class Trie {

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for (char aChar : chars) {
            if (!node.nodeMap.containsKey(aChar)) {
                node.nodeMap.put(aChar, new TrieNode());
            }
            node = node.nodeMap.get(aChar);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char ch : chars) {
            if (node.nodeMap.containsKey(ch)) {
                node = node.nodeMap.get(ch);
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode node = root;
        for (char ch : chars) {
            if (!node.nodeMap.containsKey(ch)) {
                return false;
            }
            node = node.nodeMap.get(ch);
        }
        return true;
    }

    public static class TrieNode {
        public Map<Character, TrieNode> nodeMap = new HashMap<>();
        public Boolean isEnd = false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
