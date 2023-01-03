
// https://leetcode.com/problems/detect-capital/

class Solution {
public:
    bool detectCapitalUse(string word) {
        if(word.length()==1)
            return true;
        if(word[0]<=90){
            if(word[1]<=90){
                for(int i=1; i<word.size(); i++){
                    if(word[i]>90)
                        return false;
                }
            }else{
                for(int i=1; i<word.size(); i++){
                    if(word[i]<97)
                        return false;
                }
            }
        }else{
            for(int i=1; i<word.size(); i++){
                if(word[i]<97)
                    return false;
            }
        }
        return true;
    }
};