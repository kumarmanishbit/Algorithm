package com.mani.soni.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * A trie is a special tree that can compactly store strings.
 * Other Name:- radix tree, prefix tree, digital tree
 *
 */
public class TrieDS {

    private TrieNode rootNode;

    private static final char END_OF_WORD_MARKER = '\0';

    public TrieDS() {
        this.rootNode = new TrieNode();
    }

    public boolean addWord(String word) {
        TrieNode current = rootNode;
        boolean isNewWord = false;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);

            if(!current.hasChildNode(character)) {
                current.makeChildNode(character);
                isNewWord = true;
            }

            current = current.getChildNode(character);
        }

        if(!current.hasChildNode(END_OF_WORD_MARKER)) {
            isNewWord = true;
            current.makeChildNode(END_OF_WORD_MARKER);
        }

        return isNewWord;
    }

    static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean isEnd;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public boolean hasChildNode(char character) {
            return this.children.containsKey(character);
        }


        public TrieNode getChildNode(char character) {
            return children.get(character);
        }

        public void makeChildNode(char character) {
            this.children.put(character, new TrieNode());
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}
