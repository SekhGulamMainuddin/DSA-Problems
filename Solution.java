import java.util.*;

public class Solution {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine(); // Consume newline

        char[][] cArr = new char[h][w];
        boolean[][] visited = new boolean[h][w];

        // Read input grid
        for (int i = 0; i < h; i++) {
            cArr[i] = sc.nextLine().toCharArray();
        }

        // Iterate over all possible starting positions
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (cArr[i][j] == '.') {  // Start DFS from open cell
                    visited[i][j] = true;
                    dfs(cArr, visited, i, j, k);
                    visited[i][j] = false; // Backtrack
                }
            }
        }

        System.out.println(count);
        sc.close();
    }

    private static void dfs(char[][] cArr, boolean[][] visited, int i, int j, int k) {
        if (k == 0) {
            count++;
            return;
        }

        // Move Left
        if (j - 1 >= 0 && cArr[i][j - 1] == '.' && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            dfs(cArr, visited, i, j - 1, k - 1);
            visited[i][j - 1] = false; // Backtrack
        }

        // Move Right
        if (j + 1 < cArr[0].length && cArr[i][j + 1] == '.' && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            dfs(cArr, visited, i, j + 1, k - 1);
            visited[i][j + 1] = false; // Backtrack
        }

        // Move Up
        if (i - 1 >= 0 && cArr[i - 1][j] == '.' && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            dfs(cArr, visited, i - 1, j, k - 1);
            visited[i - 1][j] = false; // Backtrack
        }

        // Move Down
        if (i + 1 < cArr.length && cArr[i + 1][j] == '.' && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            dfs(cArr, visited, i + 1, j, k - 1);
            visited[i + 1][j] = false; // Backtrack
        }
    }
}
