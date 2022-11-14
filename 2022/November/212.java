/*
 * Shortest Path in a Grid with Obstacles Elimination
 *
 * Top 37% (572ms) 
 * 
 * Tries + DFS. Not my best but leetcode hard is hard.
 * 
 * Time Complexity: O(n * n * m) I think? idk about this one
 */

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode[] nodes = new TrieNode[26];
        Set<String> solSet = new HashSet<String>();
        
        // build the trie
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            TrieNode curr = nodes[word[0] - 'a'];
            if (curr == null) {
                nodes[word[0] - 'a'] = new TrieNode(word[0]);
                curr = nodes[word[0] - 'a'];
            }
            if (word.length == 1)  {
                curr.setEnd(words[i]);
            }
            for (int j = 1; j < word.length; j++) {
                if (curr.children[word[j] - 'a'] == null) {
                    curr.children[word[j] - 'a'] = new TrieNode(word[j]);
                }
                if (j == word.length - 1) {
                    curr.children[word[j] - 'a'].setEnd(words[i]);
                }
                curr = curr.children[word[j] - 'a'];
            }
        }

        // dfs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];  

                if (nodes[board[i][j] - 'a'] != null) {
                    // System.out.println("valid start " + board[i][j]);
                    dfs(new Coord(i, j, nodes[board[i][j] - 'a']), visited, board, solSet);
                }
            }
        }

        return new ArrayList<String>(solSet);
    }

    public void dfs(Coord c, boolean[][] visited, char[][] board, Set<String> solSet) {
        if (visited[c.x][c.y] == false && c.node != null) {
            visited[c.x][c.y] = true;

            if (c.node.isEnd == true) {
                // System.out.println(c.node.word);
                solSet.add(c.node.word);
            }

            if (c.x + 1< board.length) {
                dfs(new Coord(c.x + 1, c.y, c.node.children[board[c.x + 1][c.y] - 'a']), visited, board, solSet);
            }
            if (c.x - 1 >= 0) {
                dfs(new Coord(c.x - 1, c.y, c.node.children[board[c.x - 1][c.y] - 'a']), visited, board, solSet);
            }
            if (c.y + 1 < board[0].length) {
                dfs(new Coord(c.x, c.y + 1, c.node.children[board[c.x][c.y + 1] - 'a']), visited, board, solSet);
            }
            if (c.y - 1 >= 0) {
                dfs(new Coord(c.x, c.y - 1, c.node.children[board[c.x][c.y - 1] - 'a']), visited, board, solSet);
            }
            
            visited[c.x][c.y] = false;
        }
    }

    private void pushValidSquare(int x, int y, TrieNode node, Stack<Coord> q, char[][] board, boolean[][] visited) {
        
    }

    private boolean[][] duplicateArray(boolean[][] board) {
        boolean[][] newBoard = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                newBoard[i][k] = board[i][k];
            }
        }

        return newBoard;
    }

    private class TrieNode {
        char c;
        TrieNode[] children = new TrieNode[26];
        String word;
        boolean isEnd = false;

        private TrieNode(char c) {
            this.c = c;
        }

        private void setEnd(String word) {
            isEnd = true;
            this.word = word;
        }
    }

    private class Coord {
        int x;
        int y;
        TrieNode node;

        private Coord(int x, int y, TrieNode node) {
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }
}

/*
["o","a","a","n"]
["e","t","a","e"]
["i","h","k","r"]
["i","f","l","v"]
*/