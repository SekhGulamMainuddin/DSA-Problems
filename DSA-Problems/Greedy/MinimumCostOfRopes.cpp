
// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

class Solution
{
    public:
    //Function to return the minimum cost of connecting the ropes.
    long long minCost(long long arr[], long long n) {
        // Your code here
        priority_queue<long long, vector<long long>, greater<long long>> q;
        
        for(long long i=0; i<n; i++){
            q.push(arr[i]);
        }
        
        long long totalCost= 0;
        
        while(q.size()>1){
            long long a= q.top();
            q.pop();
            
            long long b= q.top();
            q.pop();
            
            long long cost= a+b;
            totalCost+= cost;
            
            q.push(cost);
            
        }
        
        return totalCost;
        
    }
};