
// https://leetcode.com/problems/word-search/
// https://leetcode.com/problems/word-search/discuss/2094020/0ms-TLE_explained-100faster

class Solution 
{
    bool dfs(vector<vector<char>> &arr, string word, int k, int r, int c)
    {
        
        if(r>=arr.size()||r<0||c>=arr[0].size()||c<0||arr[r][c] != word[k])
            return false;

            k++;
            if(k==word.size())
                return true;
            arr[r][c]='.';
            bool res =  dfs(arr,word,k,r+1,c) || 
						dfs(arr,word,k,r-1,c) || 
						dfs(arr,word,k,r,c+1) ||
						dfs(arr,word,k,r,c-1);
            
            arr[r][c]=word[k-1];
        return res;
    }
    
public:
    bool exist(vector<vector<char>>& arr, string& word) {
        int R = arr.size(), C = arr[0].size(), N = word.size();

        // Prune #1: the arr cannot contain the word.
        if (N > R * C) return false;

        // Prune #2: the arr does not contain all occurrences of the chars in the word.
        unordered_map<char, int> occ;
        for (auto& row : arr) for (auto& c : row) ++occ[c];
        for (auto& c : word) if(--occ[c] < 0) return false;

        // Prune #3: Find the longest prefix/suffix of the same character. If the longest
        // suffix is longer than the longest prefix, swap the strigns (so we are less
        // likely to have a long prefix with a lot of the same character).
        int left = word.find_first_not_of(word[0]);
        int right = N - word.find_last_not_of(word[N - 1]);
        if (left > right) reverse(begin(word), end(word));

        for(int i=0;i<arr.size();i++)
            for(int j=0;j<arr[0].size();++j)
                if(dfs(arr,word,0,i,j))
                    return true;
        return false;
    }
};