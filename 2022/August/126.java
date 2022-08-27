/*
 * Word Ladder II
 * 
 * Top 5% (84ms) - I have no shame with leetcode hard
 * 
 * BFS to build the graph
 * DFS to find the shortest paths
 * 
 * Why? I got no idea
 *
 * Time complexity: O(n * b) where n is the string length and b is the number of words to be checked
*/

class Solution {
    List<List<String>> solutions = new ArrayList<List<String>>();
    HashMap<String, Set<String>> graph = new HashMap<String, Set<String>>();
    HashMap<String, Integer> wordDists = new HashMap<String, Integer>();
    Stack<String> wordStack = new Stack<String>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        // PREP
        int wordLength = beginWord.length();
        if (wordList.contains(endWord) == false) {
            return solutions;
        }
        
        // BFS
        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distQueue = new LinkedList<Integer>();
        HashMap<String, Boolean> seen = new HashMap<String, Boolean>();
        int minDist = Integer.MAX_VALUE;;
        
        wordQueue.add(endWord);
        distQueue.add(0);
       
        
        for (int i = 0; i < wordList.size(); i++) {
            graph.put(wordList.get(i), new HashSet<String>());
            seen.put(wordList.get(i), false);
        }
        graph.put(beginWord, new HashSet<String>());
        
        seen.put(endWord, true);
        
        while (wordQueue.size() > 0) {
            String word = wordQueue.poll();
            int dist = distQueue.poll();
            wordDists.put(word, dist);
            
            for (int i = 0; i < wordLength; i++) {
                for (int j = 0; j < 26; j++) {
                    String newWord = word.substring(0, i) + (char)('a' + j) + word.substring (i + 1, wordLength);
                    
                    if (newWord.equals(word) == false) {
                        if (newWord.equals(beginWord)) {
                            if (minDist > dist + 1) {
                                minDist = dist + 1;
                            }
                            graph.get(beginWord).add(word);
                        }
                        else {
                            if (graph.containsKey(newWord)) {
                                graph.get(newWord).add(word);
                                graph.get(word).add(newWord);
                                if (seen.get(newWord) == false) {
                                    seen.put(newWord, true);
                                    wordQueue.add(newWord);
                                    distQueue.add(dist + 1);
                                }   
                            }
                        }
                    }
                }
            }
        }
        
        if (minDist == Integer.MAX_VALUE) {
            return solutions;
        }
        
        //DFS
        wordStack.push(beginWord);
        for (String neighbour : graph.get(beginWord)) {
            if (wordDists.get(neighbour) == minDist - 1) {
                wordStack.push(neighbour);
                dfs(neighbour, endWord);
                wordStack.pop();
            }
        }
        
        return solutions;
    }
    
    public void dfs(String word, String endWord) {
        if (word.equals(endWord)) {
            solutions.add(new ArrayList<String>(wordStack));
        }
        else {
            for (String neighbour : graph.get(word)) {
                // we only care about going to words that lead us closer to the ending word
                // and are adjacent.
                if (wordDists.get(neighbour) == wordDists.get(word) - 1) {
                    wordStack.push(neighbour);
                    dfs(neighbour, endWord);
                    wordStack.pop();
                }
            }
        }
    }
}