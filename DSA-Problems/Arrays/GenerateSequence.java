import java.util.*;

class Solution {

    public int[][] generateSchedule(int n) {
        // For n <= 3, impossible to create valid schedule
        if (n <= 3) return new int[][]{};

        int totalMatches = n * (n - 1);   // Each ordered pair (i, j), i != j
        int[][] result = new int[totalMatches][2];

        // Track if (i, j) has already been scheduled
        boolean[][] used = new boolean[n][n];

        // Track how many matches each team has played
        int[] matchCount = new int[n];

        // Start with (0,1) as the first match
        result[0] = new int[]{0, 1};
        used[0][1] = true;
        matchCount[0]++;
        matchCount[1]++;

        // Begin backtracking from index = 1
        if (backtrack(n, result, 1, used, matchCount)) {
            return result;
        }

        return new int[][]{}; // should not happen for n >= 4
    }

    private boolean backtrack(int n, int[][] result, int idx,
                              boolean[][] used, int[] matchCount) {
        // ✅ Base case: placed all matches
        if (idx == result.length) return true;

        // Order teams by how many matches they’ve played (balance)
        Integer[] teams = new Integer[n];
        for (int i = 0; i < n; i++) teams[i] = i;
        Arrays.sort(teams, Comparator.comparingInt(a -> matchCount[a]));

        // Try every team as first participant
        for (int i = 0; i < n; i++) {
            int t1 = teams[i];

            // Cannot reuse teams from previous match
            if (t1 == result[idx - 1][0] || t1 == result[idx - 1][1]) continue;

            // Try pairing t1 with another team
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int t2 = teams[j];

                // Cannot reuse teams from previous match
                if (t2 == result[idx - 1][0] || t2 == result[idx - 1][1]) continue;

                // Match must not be already used
                if (used[t1][t2]) continue;

                // Place match
                result[idx] = new int[]{t1, t2};
                used[t1][t2] = true;
                matchCount[t1]++;
                matchCount[t2]++;

                // Recurse
                if (backtrack(n, result, idx + 1, used, matchCount)) {
                    return true;
                }

                // 🔄 Backtrack
                used[t1][t2] = false;
                matchCount[t1]--;
                matchCount[t2]--;
                result[idx] = new int[]{0, 0};
            }
        }

        return false; // no valid assignment at this level
    }

}
