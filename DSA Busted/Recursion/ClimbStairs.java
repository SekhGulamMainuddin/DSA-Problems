class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(countDistinctWayToClimbStair(12));
    }

    private static int countDistinctWayToClimbStair(int nStairs)
    {
        //base case
        if(nStairs < 0)
            return 0;
    
        if(nStairs == 0)
            return 1;
    
        //R.C
        int ans = countDistinctWayToClimbStair(nStairs-1) 
            + countDistinctWayToClimbStair(nStairs-2);
    
        return ans;
    }
}