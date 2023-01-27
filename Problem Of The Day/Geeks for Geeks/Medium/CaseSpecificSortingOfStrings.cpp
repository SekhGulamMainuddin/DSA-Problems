
// https://practice.geeksforgeeks.org/problems/case-specific-sorting-of-strings4845/1

class Solution
{
    public:
    //Function to perform case-specific sorting of strings.
    string caseSort(string str, int n)
    {
        vector<char> lower,upper;
        string ans;
        bool arr[n];
        for(int i=0;i<n;i++){
            if(str[i]>='a' and str[i]<='z'){
                arr[i]=true;
                lower.push_back(str[i]);
            }
            if(str[i]>='A' and str[i]<='Z'){
                arr[i]=false;
                upper.push_back(str[i]);
            }
        }
        sort(lower.begin(),lower.end());
        sort(upper.begin(),upper.end());
        int j=0,k=0;
        for(int i=0;i<n;i++){
            if(arr[i]==true){
                ans+=lower[j];
                j++;
            }
            if(arr[i]==false){
                ans+=upper[k];
                k++;
            }
        }
        return ans;
        
    }
};