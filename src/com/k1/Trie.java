package com.k1;

import java.util.*;

class Trie {
    static class TrieN {
        Map<Character, TrieN> children = new TreeMap<Character, TrieN>();
        boolean ind;
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
    public static void main(String[] args) {}
}