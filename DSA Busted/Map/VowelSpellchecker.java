// https://leetcode.com/problems/vowel-spellchecker/

import java.util.*;

class VowelSpellchecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // 1. Store exact words for O(1) exact match lookup
        HashSet<String> exactWords = new HashSet<>();

        // 2. Store first occurrence of each lowercase word
        //    → handles case-insensitive matching
        HashMap<String, String> caseInsensitiveMap = new HashMap<>();

        // 3. Store first occurrence of each "devoweled" lowercase word
        //    → handles vowel errors
        HashMap<String, String> vowelMap = new HashMap<>();

        // --- Preprocessing wordlist ---
        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            // Only keep the *first occurrence* of a case-insensitive word
            caseInsensitiveMap.putIfAbsent(lower, word);

            String devowel = devowel(lower);
            // Only keep the *first occurrence* of a devoweled word
            vowelMap.putIfAbsent(devowel, word);
        }

        // --- Answer each query ---
        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            // 1. Exact match (case-sensitive)
            if (exactWords.contains(query)) {
                ans[i] = query;
                continue;
            }

            // 2. Case-insensitive match
            String lower = query.toLowerCase();
            if (caseInsensitiveMap.containsKey(lower)) {
                ans[i] = caseInsensitiveMap.get(lower);
                continue;
            }

            // 3. Vowel error match
            String devowel = devowel(lower);
            ans[i] = vowelMap.getOrDefault(devowel, "");
        }

        return ans;
    }

    /**
     * Convert a word into its "devoweled" form:
     * Replace all vowels (a,e,i,o,u) with '0'.
     * Example: "Google" -> "g00gl0"
     */
    private String devowel(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('0');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
