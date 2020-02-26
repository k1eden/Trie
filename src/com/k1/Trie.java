package com.k1;

import java.util.*;

public class Trie {
    static class TrieN {
        Map<Character, TrieN> children = new TreeMap<Character, TrieN>();
        boolean ind;
        Map<Character, TrieN> getChildren() {
            return children;
        }

        boolean isEndOfWord() {
            return ind;
        }

        void setEndOfWord(boolean endOfWord) {
            this.ind = endOfWord;
        }
    }

    TrieN root = new TrieN();

    
    public boolean find(String s) {
        TrieN ex = root;
        for (char ch : s.toLowerCase().toCharArray()) {
            if (!ex.children.containsKey(ch)) {
                return false;
            } else {
                ex = ex.children.get(ch);
            }
        }
        return true;
    }


    public void put(String s) {
        TrieN ex = root;
        for (char ch : s.toLowerCase().toCharArray()) {
            if (!ex.children.containsKey(ch)) {
                ex.children.put(ch, new TrieN());
            }
            ex = ex.children.get(ch);
        }
        ex.ind = true;
    }


    static Map<Integer, String> levelSpacesMap = new HashMap<Integer, String>();

    static String getSpace(int level) {
        String result = levelSpacesMap.get(level);
        if (result == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append(" ");
            }
            result = sb.toString();
            levelSpacesMap.put(level, result);
        }
        return result;
    }

    public static void printSorted(TrieN node) {
        printSorted2(node, 0);
    }

    private static void printSorted2(TrieN node, int level) {
        for (Character ch : node.children.keySet()) {
            System.out.println(getSpace(level) + ch);
            printSorted2(node.children.get(ch), level + 1);
        }
        if (node.ind) {
            System.out.println();
        }
    }


    public void remove(String word) {
        remove(root, word, 0);
    }

    private boolean remove(TrieN current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieN node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = remove(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}