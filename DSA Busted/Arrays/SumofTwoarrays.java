
//https://www.codingninjas.com/codestudio/problems/sum-of-two-arrays_893186?utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_4

import java.util.*;
class Solution {
	public static int[] findArraySum(int[] a, int n, int[] b, int m) {
		// Write your code here.
        int aDigit=0,bDigit=0;
        for(int i=0;i<n;i++)
            aDigit=aDigit*10+a[i];
        for(int i=0;i<m;i++)
            bDigit=bDigit*10+b[i];
        aDigit=aDigit+bDigit;
        List<Integer> ar=new ArrayList<>();
        while(aDigit!=0){
            ar.add(aDigit%10);
            aDigit=aDigit/10;
        }
        int s[]=new int[ar.size()];
        for(int i=(ar.size()-1),j=0;i>=0;i--,j++){
            s[j]=ar.get(i);
        }
        return s;
	}
}
/* More Optimised Solution
vector<int> reverse(vector<int> v) {
    
    int s = 0;
    int e = v.size()-1;
    
    while(s<e)
    {
        swap(v[s++], v[e--]);
    }
    return v;
}
vector<int> findArraySum(vector<int>&a, int n, vector<int>&b, int m) {
    
    int i = n-1;
    int j = m-1;
    vector<int> ans;
    int carry = 0;
    
    while(i>=0 && j>=0) {
        int val1 = a[i];
        int val2 = b[j];
            
        int sum = val1 + val2 + carry;   
        
        carry = sum/10;
        sum = sum%10;
        ans.push_back(sum);
        i--;
        j--;
    }
    
    // first case
    while(i>=0) {
        int sum = a[i] + carry;
        carry = sum/10;
        sum = sum%10;
        ans.push_back(sum);
        i--;
    }
    
     // second case
    while(j>=0) {
        int sum = b[j] + carry;
        carry = sum/10;
        int value = sum%10;
        ans.push_back(value);
        j--;
    }
    
     // second case
    while(carry != 0) {
        int sum = carry;
        carry = sum/10;
        sum = sum%10;
        ans.push_back(sum);
    }
    
    //print(ans);
    return reverse(ans);
}
*/