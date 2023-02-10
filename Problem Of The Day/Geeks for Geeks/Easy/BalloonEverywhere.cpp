
// https://practice.geeksforgeeks.org/problems/45fa306a9116332ece4cecdaedf50f140bd252d4/1

class Solution{
public:
    int maxInstance(string s){
          int arr[26]={0};

        for(int i=0;i<s.length();i++){

            arr[s[i]-'a']++;

        }

        //we care about only the characters in "ballon"

      int  mini=INT_MAX;

        mini=min(min(min(arr[0],arr[1]),min(arr[11]/2,arr[14]/2)),arr[13]);

        return mini;
    }
};