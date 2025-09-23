// https://leetcode.com/problems/h-index-ii/

class HIndexII {
    public int hIndex(int[] citations) {
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