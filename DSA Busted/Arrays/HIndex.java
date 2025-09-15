// https://leetcode.com/problems/h-index

import java.util.Arrays;

class HIndex {
    public int hIndex(int[] citations) {
        /// Brute Force - O (n * m)
        // int hValue = citations[0];
        // if(hValue>1) {
        //     hValue = 1;
        // }
        // int maxValue = 0;
        // for(int i : citations) {
        //     maxValue = Math.max(i, maxValue);
        // }

        // for(int i=0; i<=maxValue; i++) {
        //     int count = 0;
        //     for(int j : citations) {
        //         if(j>=i) {
        //             count++;
        //         }
        //     }

        //     if(count>=i) {
        //         hValue = Math.max(hValue, i);
        //     }
        // }

        // return hValue; 
         
        Arrays.sort(citations);
        int n = citations.length;
        int s=0, e=n-1, m = 0;

        while(s<=e) {
            m = (s+e)/2;
            if(citations[m]==(n-m)) {
                return citations[m];
            } else if (citations[m]<(n-m)) {
                s=m+1;
            } else {
                e=m-1;
            }
        }

        return n-s;  
    }
}