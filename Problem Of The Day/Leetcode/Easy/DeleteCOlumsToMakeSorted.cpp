
// https://leetcode.com/problems/delete-columns-to-make-sorted/description/

class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        int nDelete= 0;

        for(int i=0; i<strs[0].length(); i++){
            for(int j=0; j<strs.size()-1; j++){
                if(strs[j][i]>strs[j+1][i]){
                    nDelete++;
                    break;
                }
            }
        }
        return nDelete;
    }
};