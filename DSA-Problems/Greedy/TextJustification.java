// https://leetcode.com/problems/text-justification

import java.util.ArrayList;
import java.util.List;

class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;

        while (startIndex < words.length) {
            int endIndex = startIndex, wordsLength = 0;

            // Step 1: Determine how many words fit in this line
            while (endIndex < words.length && 
                   wordsLength + words[endIndex].length() + (endIndex - startIndex) <= maxWidth) {
                wordsLength += words[endIndex].length();
                endIndex++;
            }

            StringBuilder lineBuilder = new StringBuilder();
            int numGaps = endIndex - startIndex - 1; // spaces between words

            // Step 2: Last line OR only one word → left justify
            if (endIndex == words.length || numGaps == 0) {
                for (int wordIndex = startIndex; wordIndex < endIndex; wordIndex++) {
                    lineBuilder.append(words[wordIndex]);
                    if (wordIndex < endIndex - 1) {
                        lineBuilder.append(" ");
                    }
                }
                // Fill trailing spaces
                while (lineBuilder.length() < maxWidth) {
                    lineBuilder.append(" ");
                }
            } else {
                // Step 3: Fully justify line
                int totalSpaces = maxWidth - wordsLength;
                int minSpacesPerGap = totalSpaces / numGaps;
                int extraSpaces = totalSpaces % numGaps;

                for (int wordIndex = startIndex; wordIndex < endIndex; wordIndex++) {
                    lineBuilder.append(words[wordIndex]);
                    if (wordIndex < endIndex - 1) {
                        // Add minimum spaces
                        for (int s = 0; s < minSpacesPerGap; s++) {
                            lineBuilder.append(" ");
                        }
                        // Distribute extra spaces to first 'extraSpaces' gaps
                        if (wordIndex - startIndex < extraSpaces) {
                            lineBuilder.append(" ");
                        }
                    }
                }
            }

            result.add(lineBuilder.toString());
            startIndex = endIndex; // move to next line
        }

        return result;
    }
}