
// https://www.codingninjas.com/codestudio/problems/maximum-frequency-number_920319?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

int maximumFrequency(vector<int> &arr, int n)
{
    //Write your code here
    unordered_map<int,int> frequencyMap;
    for(auto i : arr){
        frequencyMap[i]++;
    }
    int ans= arr[0];
    for(auto i : arr){
        if(frequencyMap[ans]<frequencyMap[i])
            ans= i;
    }
    return ans;
}