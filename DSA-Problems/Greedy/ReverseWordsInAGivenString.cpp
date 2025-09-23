
// https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1

class Solution
{
    public:
    //Function to reverse words in a given string.
    string reverseWords(string S) 
    { 
        // code here 
        string temp= "";
        string ans= "";
        for(int i=S.length()-1; i>=0; i--){
            if(S[i]!='.'){
                temp.push_back(S[i]);
            }
            else{
                reverse(temp.begin(), temp.end());
                ans+= temp;
                ans.push_back('.');
                temp= "";
            }
        }
        reverse(temp.begin(), temp.end());
        ans+= temp;
        return ans;
        
    } 
};