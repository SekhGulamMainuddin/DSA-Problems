// https://www.geeksforgeeks.org/problems/alien-dictionary/1

import java.util.*;

class AlienDictionary {
    public String findOrder(String[] words) {
        // Step 1: Initialize the graph for 26 lowercase letters (a-z)
        // We use an adjacency list representation where each character maps to a set of characters that come after it
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new HashSet<>());  // Using a HashSet to prevent duplicate edges
        }
        
        int[] inDegree = new int[26];   // Array to track incoming edges (dependencies) for each character
        boolean[] isPresent = new boolean[26];  // Boolean array to track which characters appear in the input words

        // Step 2: Mark all characters that appear in words
        for (String str : words) {
            for (char ch : str.toCharArray()) {
                isPresent[ch - 'a'] = true;  // Mark character as present in the dictionary
            }
        }

        // Count total unique characters in words[]
        int uniqueCharacters = 0;
        for (boolean present : isPresent) {
            if (present) uniqueCharacters++;
        }

        // Step 3: Build the graph using character relationships from adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;  // Flag to check if we found an ordering relationship

            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int u = word1.charAt(j) - 'a'; // Convert character to integer index
                    int v = word2.charAt(j) - 'a';

                    // Add edge u -> v (word1[j] should come before word2[j])
                    if (!graph.get(u).contains(v)) { 
                        graph.get(u).add(v);
                        inDegree[v]++;  // Increase in-degree of 'v' (dependency count)
                    }
                    foundDifference = true;
                    break;  // Stop at the first different character
                }
            }

            // Edge case: If word1 is longer than word2 and word1 starts with word2 (invalid order)
            if (!foundDifference && word1.length() > word2.length()) {
                return "";  // Invalid order detected
            }
        }

        // Step 4: Perform Topological Sorting using Kahn's Algorithm (BFS)
        Queue<Integer> queue = new LinkedList<>();

        // Add nodes with zero in-degree (no dependencies) to the queue
        for (int i = 0; i < 26; i++) {
            if (isPresent[i] && inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 5: Process nodes in the queue using BFS
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            int u = queue.poll();  // Get character with zero in-degree
            result.append((char) (u + 'a'));  // Convert back to character and add to result

            // Reduce in-degree of neighboring nodes
            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {  // If in-degree becomes zero, add to queue
                    queue.offer(v);
                }
            }
        }

        // Step 6: If the result does not contain all unique characters, there's a cycle
        if (result.length() < uniqueCharacters) {
            return "";  // Invalid order due to cycle
        }

        return result.toString();  // Return the valid character order
    }
}
