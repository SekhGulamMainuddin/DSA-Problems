import java.io.*;
import java.util.*;
class Solution
{
   boolean check_elements(int arr[], int n, int A, int B)
   {
       int x=B-A+1;
       int count=0;
       HashSet<Integer> set=new HashSet<>();
       for(int i:arr){
           set.add(i);
       }

      for(int i:set){
          if(i>=A && i<=B)
          count++;
      }
      if(count==x)
      return true;

      return false;
   }
}

/*
class Solution
{
    boolean check_elements(int arr[], int n, int A, int B)
    {
        int nf=0;
        if(A>B){
            for(int i=B;i<=A;i++){
                for(int j : arr){
                    if(j==i){
                        nf=0;
                        break;
                    }else{
                        nf++;
                    }
                }
                if(nf>0)
                    return false;
            }
        }else{
            for(int i=A;i<=B;i++){
                for(int j : arr){
                    if(j==i){
                        nf=0;
                        break;
                    }else{
                        nf++;
                    }
                }
                if(nf>0)
                    return false;
            }
        }
        return true;
    }
}
*/