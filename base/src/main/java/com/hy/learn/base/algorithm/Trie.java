package com.hy.learn.base.algorithm;

import lombok.Data;

/**
 * @author Created by hy
 * @date on 2021/5/24 10:14
 */
public class Trie {

    @Data
    class TrieNode {
        char text;
        TrieNode[] children = new TrieNode[26];

        boolean isEndingChar = false;

        TrieNode(char text) {
            this.text = text;
        }
    }

    private TrieNode root = new TrieNode('/');

    void insert(char[] text) {
        TrieNode p = root;

        for (int i = 0; i < text.length; i++) {
            int offset = text[i] - 'a';
            if (p.children[offset] == null) {
                TrieNode newTrieNode = new TrieNode(text[i]);
                p.children[offset] = newTrieNode;
            }

            p = p.children[offset];
        }

        p.isEndingChar = true;
    }

    boolean find(char[] pattern) {
        TrieNode p = root;

        for (int i = 0; i < pattern.length; i++) {
            int offset = pattern[i] - 'a';

            if (p.children[offset] == null) {
                return false;
            }

            p = p.children[offset];
        }

        return p.isEndingChar;
    }

}
