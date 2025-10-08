// https://leetcode.com/problems/rotate-image/


class Rotate90 {
    public void rotate(int[][] matrix) {
        // Step 1️⃣: Transpose the matrix
        // --------------------------------
        // Transpose means converting all rows into columns.
        // i.e., matrix[i][j] ↔ matrix[j][i]
        //
        // We only swap elements above the diagonal (j starts from i)
        // to avoid swapping back the same elements twice.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2️⃣: Reverse each row
        // --------------------------------
        // After transpose, reversing each row gives the rotated matrix.
        // This achieves a 90° clockwise rotation.
        //
        // Example:
        // Before transpose:
        //  1 2 3
        //  4 5 6
        //  7 8 9
        //
        // After transpose:
        //  1 4 7
        //  2 5 8
        //  3 6 9
        //
        // After reversing each row:
        //  7 4 1
        //  8 5 2
        //  9 6 3
        // ✅ => 90° rotated clockwise matrix
        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix.length - 1;

            // Reverse the row using two-pointer approach
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;

                start++;
                end--;
            }
        }

    }
}
