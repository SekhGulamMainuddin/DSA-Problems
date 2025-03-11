#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
int n,m;
int dx[]={0,0,-1,1};
int dy[]={-1,1,0,0};
ll help(vector<string>&v ,int i,int j,int k){
    if(k==0)return 1;
    ll ans=0;
    for(int p=0;p<4;p++){
        int ni=i+dx[p];
        int nj=j+dy[p];
        if(ni>=0 && nj>=0 && ni<n && nj<m && v[ni][nj]=='.'){
            v[ni][nj]='#';
            ans+=help(v,ni,nj,k-1);
            v[ni][nj]='.';
        }
    }
    return ans;
}

int main(){
    int k;
    cin>>n>>m>>k;
    vector<string> v(n),t;
    for(auto &i:v)cin>>i;
    ll ans=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(v[i][j]=='.'){
                v[i][j]='#';
                ans+=help(v,i,j,k);
                v[i][j]='.';
            }
        }
    }
    cout<<ans;
}