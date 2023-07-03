package DSA45DaysArshGoyalSheet.Arrays;

// https://leetcode.com/problems/set-matrix-zeroes/

import java.util.*;

// Constant Space
class Solution1 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean fr = false, fc = false;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                fr = true;
            }
        }
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) {
                fc = true;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (fr == true) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        if (fc == true) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}

// Constant Space but capable with missing testcase value i.e. -9999999 which is not reliable
class Solution2 {
    public void markZero(int row, int column, int[][] matrix){
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[row][i]!=0){
                matrix[row][i]= -9999999;
            }
        }
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][column]!=0){
                matrix[i][column]= -9999999;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    markZero(i, j, matrix);
                }
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==-9999999){
                    matrix[i][j]= 0;
                }
            }
        }
    }
}

// SC - O(m+n)
class Solution3 {
    public void setZeroes(int[][] matrix){

		int m=matrix.length, n=matrix[0].length;
        int rowsArray[]= new int[m];
        int colsArray[]= new int[n];
        
        Arrays.fill(rowsArray,1);
        Arrays.fill(colsArray,1);
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowsArray[i]=0;
                    colsArray[j]=0;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowsArray[i]==0 || colsArray[j]==0)
                    matrix[i][j]=0;
            }
        }
    }
}

// SC - O(m*n)
class Solution4 {
    public void setZeroes(int[][] matrix) {
        List<int[]> zeroIndex = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroIndex.add(new int[]{i, j});
                }
            }
        }
        for (int[] p : zeroIndex) {
            int row = p[0];
            int col = p[1];
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
