// https://leetcode.com/problems/word-ladder/

/*
Intuition:
- The problem is a variation of the shortest path problem in an unweighted graph.
- Each word is a node, and we can transform one word to another by changing one letter at a time.
- The goal is to find the shortest transformation sequence from `beginWord` to `endWord`.

Approach:
- Use **Breadth-First Search (BFS)** since it guarantees the shortest path in an unweighted graph.
- Store all words in a `HashSet` for **O(1) lookup**.
- Start BFS from `beginWord` and explore all possible single-letter transformations.
- If `endWord` is reached, return the transformation count.
- Remove words from the set once visited to prevent cycles.

Time Complexity:
- **O(M^2 * N)**, where M = word length, N = wordList size.
  - Generating transformations takes O(M).
  - Checking if the word exists in the set is O(1).
  - In the worst case, we visit all words O(N).

Space Complexity:
- **O(N)** for the `HashSet` and `Queue` storage.
*/

import java.util.*;

class WordLadder {
    // Helper class to store a word and its discovery time (distance from beginWord)
    private static class Word {
        String word;
        int discoveryTime;

        Word(String word, int discoveryTime) {
            this.word = word;
            this.discoveryTime = discoveryTime;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Store words in a set for quick lookup
        Set<String> set = new HashSet<>(wordList);
        
        // If the endWord is not in the list, transformation is impossible
        if (!set.contains(endWord)) {
            return 0;
        }

        // BFS queue to store words and their transformation levels
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(beginWord, 1));

        while (!q.isEmpty()) {
            Word w = q.poll();
            
            // If we reach the endWord, return the number of transformations
            if (w.word.equals(endWord)) {
                return w.discoveryTime;
            }

            // Try changing each character in the word
            for (int i = 0; i < w.word.length(); i++) {
                char[] ns = w.word.toCharArray(); // Convert word to char array for easy modification
                
                // Iterate over all lowercase letters 'a' to 'z'
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (w.word.charAt(i) != ch) { // Avoid replacing with the same character
                        ns[i] = ch;
                        String value = String.valueOf(ns); // Convert char array back to string
                        
                        // If the transformed word exists in the set, add to queue
                        if (set.contains(value)) {
                            set.remove(value); // Remove from set to avoid revisiting
                            q.add(new Word(value, w.discoveryTime + 1));
                        }
                    }
                }
            }
        }

        return 0; // If endWord is not reachable, return 0
    }
}
