/*
 * Implement Trie (Prefix Tree)
 * 
 * Top 60% (40ms)
 * 
 * idk why my solutions is 5ms slower than the top 90%, but whatever I guess
 * 
 * Time Complexity: O(n) where n is the total character count
 */

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.children[currChar - 'a'] == null) {
                curr.children[currChar - 'a'] = new TrieNode();
            }

            curr =  curr.children[currChar - 'a'];
            if (i == word.length() - 1) {
                curr.isEnd = true;
            }
        }
    }

    private TrieNode traverse(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.children[currChar - 'a'] == null) {
                return null;
            }
            curr =  curr.children[currChar - 'a'];
        }

        return curr;
    }
    
    public boolean search(String word) {
        TrieNode lastNode = traverse(word);
        if (lastNode == null || lastNode.isEnd == false) {
            return false;
        }

        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode lastNode = traverse(prefix);
        if (lastNode == null) {
            return false;
        }

        return true;
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode () {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */