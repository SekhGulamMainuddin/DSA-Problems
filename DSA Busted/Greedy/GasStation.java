// https://leetcode.com/problems/gas-station/

class GasStation {
    public int candy(int[] ratings) {
        /* TC: O(n), SC: O(n)
        int n = ratings.length;
        int[] candies = new int[n];
        int sum = n;
        
        for(int i=0; i<n; i++) {
            int prev = candies[i];
            if(i>0 && ratings[i-1]<ratings[i] && i<n-1 && ratings[i+1]<ratings[i]) {
                candies[i] = Math.max(candies[i-1], candies[i+1])+1;
            } else if(i>0 && ratings[i-1]<ratings[i]) {
                candies[i] = candies[i-1]+1;
            } else if(i<n-1 && ratings[i+1]<ratings[i]) {
                candies[i] = candies[i+1]+1;
            }
            if(prev!=candies[i]) {
                sum+=candies[i]-prev;
            } 
        }

        for(int i=n-1; i>=0; i--) {
            int prev = candies[i];
            if(i>0 && ratings[i-1]<ratings[i] && i<n-1 && ratings[i+1]<ratings[i]) {
                candies[i] = Math.max(candies[i-1], candies[i+1])+1;
            } else if(i>0 && ratings[i-1]<ratings[i]) {
                candies[i] = candies[i-1]+1;
            } else if(i<n-1 && ratings[i+1]<ratings[i]) {
                candies[i] = candies[i+1]+1;
            }
            if(prev!=candies[i]) {
                sum+=candies[i]-prev;
            }
        }

        return sum;
        */


        // TC: O(n), SC: O(1)
        int n = ratings.length;
        int totalCandies = n;
        int i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int currentPeak = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                currentPeak++;
                totalCandies += currentPeak;
                i++;
            }

            if (i == n) {
                return totalCandies;
            }

            int currentDepth = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                currentDepth++;
                totalCandies += currentDepth;
                i++;
            }

            totalCandies -= Math.min(currentPeak, currentDepth);
        }

        return totalCandies;
    }
}