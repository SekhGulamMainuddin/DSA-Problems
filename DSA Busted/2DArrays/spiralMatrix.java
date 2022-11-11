
//https://leetcode.com/problems/spiral-matrix/

import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int row=matrix.length;
        int col=matrix[0].length;

        List<Integer> list=new ArrayList<>();

        int count=0;

        int sRow=0;
        int eRow=row-1;
        int sCol=0;
        int eCol=col-1;
        int i;
        while(count<(row*col)){

            for(i=sCol;i<=eCol;i++){
                list.add(matrix[sRow][i]);
                count++;
            }
            sRow++;

            if(count>(row*col-1)){
                break;
            }

            for(i=sRow;i<=eRow;i++){
                list.add(matrix[i][eCol]);
                count++;
            }
            eCol--;

            if(count>(row*col-1)){
                break;
            }


            for(i=eCol;i>=sCol;i--){
                list.add(matrix[eRow][i]);
                count++;
            }
            eRow--;

            if(count>(row*col-1)){
                break;
            }


            for(i=eRow;i>=sRow;i--){
                list.add(matrix[i][sCol]);
                count++;
            }
            sCol++;

            if(count>(row*col-1)){
                break;
            }


        }
        return list;
    }
}