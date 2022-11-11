
// https://www.codingninjas.com/codestudio/problems/print-like-a-wave_893268?utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_6

class Solution {
	public static int[] wavePrint(int arr[][], int nRows, int mCols) {
		// Write your code here.
        int a[]=new int[nRows*mCols];
        int k=0;
        for(int i=0;i<mCols;i++){
            if(i%2==0){
                for(int j=0;j<nRows;j++){
                    a[k++]=arr[j][i];
                }
            }else{
                for(int j=nRows-1;j>=0;j--){
                    a[k++]=arr[j][i];
                }
            }
        }
        return a;
	}
}