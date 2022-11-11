
//https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row= matrix.length;
        int col= matrix[0].length;

        int s=0;
        int e=(row*col) - 1;
        int mid=s+(e-s)/2;
        int element;
        while(s<=e){
            element= matrix[mid/col][mid%col];
            if(element == target){
                return true;
            }else if(element>target){
                e=mid-1;
            }else{
                s=mid+1;
            }
            mid= s+(e-s)/2;
        }
        return false;
    }
}