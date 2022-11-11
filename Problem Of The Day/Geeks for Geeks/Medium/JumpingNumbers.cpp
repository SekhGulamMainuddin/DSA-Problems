
// https://practice.geeksforgeeks.org/problems/jumping-numbers3805/1

#include<iostream>
#include<queue>
using namespace std;

long long jumpingNums(long long x) {
        if(x <= 10) return x;
        
        queue<long long> q;
        
        for(int i = 1; i <= 9; i++) q.push(i);
        
        long long ans = 0;
        while(!q.empty()) {
            long long cur = q.front();
            q.pop();
            
            if(cur > x) continue;
            
            ans = max(ans,cur);
            int n = (int) cur%10;
            
            if(n) {
                long long t = cur*10+(n-1);
                q.push(t);
            }
            
            if(n != 9){
                long long t = cur*10+(n+1);
                q.push(t);
            }
        }
        
        return ans;
    }

// Time Limit Exceeded
// bool jumpingNumberOrNot(long x){
//     int positive,negative;
//     while(x>9){
//         positive= (((x/10)%10)+1);
//         negative= (((x/10)%10)-1);
//         cout<<x<<endl;
//         cout<<positive<<"  "<<negative<<endl;
//         if((x%10)!=positive && (x%10)!=negative)
//             return false;
//         x=x/10;
//     }
//     return true;
// }

int main(){
    //cout<<jumpingNumberOrNot(45);
    cout<<jumpingNums(45);
    return 0;
}