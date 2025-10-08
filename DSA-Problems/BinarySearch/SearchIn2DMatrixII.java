
// https://leetcode.com/problems/search-a-2d-matrix-ii/

class SearchIn2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }

        int row=0;
        int col=matrix[0].length-1;
        int element;
        while(row<matrix.length && col>=0){
            element=matrix[row][col];
            if(element==target)
                return true;
            else if(element>target){
                col--;
            }else{
                row++;
            }
        }
        return false;

    }
}