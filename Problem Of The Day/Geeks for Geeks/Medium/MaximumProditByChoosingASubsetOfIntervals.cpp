
// https://practice.geeksforgeeks.org/problems/649205908e04ac00f303626fa845261318adfa8f/1

class Solution {
  public:
     int *dp;

    static bool comparator(vector<int> &a,vector<int> &b){

        return a[0]<b[0];

    }

    int help(vector<vector<int>> &arr,int i,set<pair<int,int>> &st){

        int n=arr.size();

        if(i>=n)

            return 0;

        if(dp[i]!=-1)

            return dp[i];

        int nxt=n;

        auto x=st.upper_bound({arr[i][1],i});

        if(x!=st.end())

            nxt=(*x).second;

        return dp[i]=max(help(arr,i+1,st),arr[i][2]+help(arr,nxt,st));

    }

    int maximum_profit(int n, vector<vector<int>> &arr) {

        // Write your code here.

        sort(arr.begin(),arr.end(),comparator);

        set<pair<int,int>> st;

        int i;

        for(i=0;i<n;++i){

            st.insert({arr[i][0],i});

        }

        dp=new int[n+1];

        for(i=0;i<=n;++i)

            dp[i]=-1;

        return help(arr,0,st);

    }
};