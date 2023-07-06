package DSA45DaysArshGoyalSheet.Arrays;

// https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1

import java.util.*;

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long mini = a.get(0);
        long maxi = a.get(m-1);
        long diff = maxi - mini;
        for(int i=m; i<a.size(); i++){
            mini = a.get(i-m+1);
            maxi = a.get(i);
            diff = Math.min(diff, maxi-mini);
        }
        return diff;
    }
}