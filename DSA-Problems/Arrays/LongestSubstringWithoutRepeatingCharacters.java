// https://leetcode.com/problems/longest-substring-without-repeating-characters

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hasSeen = new HashSet<>();
        int maxCount = 0;
        int startIndex = 0, i = 0;

        while (i < s.length()) {
            if (hasSeen.contains(s.charAt(i))) {
                hasSeen.remove(s.charAt(startIndex++));
            } else {
                hasSeen.add(s.charAt(i++));
                maxCount = Math.max(maxCount, i - startIndex);
            }
        }

        return maxCount;
    }
}
