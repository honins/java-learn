package com.hy.learn.base.algorithm;

import org.junit.Test;

/**
 * @author Created by hy
 * @date on 2021/5/24 10:59
 */
public class TrieTest {



    @Test
    public void test(){
        Trie trie = new Trie();
        trie.insert(new char[]{'a', 'b', 'c'});
        trie.insert(new char[]{'a', 'c', 'd'});

        boolean result = trie.find(new char[]{'a', 'c', 'd'});

        System.out.println("result = " + result);
    }

}