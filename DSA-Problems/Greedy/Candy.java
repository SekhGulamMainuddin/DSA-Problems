// https://leetcode.com/problems/candy/

class Candy {
    public int candy(int[] ratings) {
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
    }
}