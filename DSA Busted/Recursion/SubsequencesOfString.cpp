
// https://www.codingninjas.com/codestudio/problems/subsequences-of-string_985087?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_16

#include <bits/stdc++.h> 

void solve(string str, string output, int index, vector<string> &ans){
    
    if(index>=str.length()){
        if(output!="")
            ans.push_back(output);
        return;
    }
    
    //exclude
    solve(str,output,index+1,ans);
    
    //include
    char s=str[index];
    output=output+s;
    solve(str,output,index+1,ans);
        
}

vector<string> subsequences(string str){
    vector<string> ans;
    int index=0;
    string output="";
    solve(str,output,index,ans);
    return ans;
}
