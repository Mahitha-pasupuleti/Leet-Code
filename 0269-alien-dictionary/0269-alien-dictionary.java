import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1); // Mark all characters as unused initially

        // Step 1: Initialize inDegree for all unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (inDegree[c - 'a'] == -1) {
                    inDegree[c - 'a'] = 0;
                }
            }
        }

        // Step 2: Build graph from adjacent word pairs
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLen = Math.min(word1.length(), word2.length());
            int j = 0;

            while (j < minLen) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    adjList.computeIfAbsent(c1, k -> new ArrayList<>()).add(c2);
                    inDegree[c2 - 'a']++;
                    break;
                }
                j++;
            }

            // Invalid case: word2 is a prefix of word1 (e.g., "abc", "ab")
            if (j == minLen && word1.length() > word2.length()) {
                return "";
            }
        }

        // Step 3: Topological sort using BFS
        Queue<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                queue.offer((char) ('a' + i));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);

            List<Character> neighbors = adjList.get(curr);
            if (neighbors != null) {
                for (char neighbor : neighbors) {
                    inDegree[neighbor - 'a']--;
                    if (inDegree[neighbor - 'a'] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Step 4: Validate result length
        int totalChars = 0;
        for (int val : inDegree) {
            if (val != -1) totalChars++;
        }

        return result.length() == totalChars ? result.toString() : "";
    }
}
