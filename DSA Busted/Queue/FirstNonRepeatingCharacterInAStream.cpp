
// https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1

class Solution {
	public:
		string FirstNonRepeating(string A){
		    // Code here
		    unordered_map<char, int> cMap;
		    queue<char> q;
		    string result;
		    
		    for(int i=0; i<A.length(); i++){
		        
		        char ch= A[i];
		        cMap[ch]++;
		        
		        q.push(ch);
		        
		        while(!q.empty()){
		            
		            if(cMap[q.front()]>1){
		                q.pop();
		            }
		            else{
		                result.push_back(q.front());
		                break;
		            }
		            
		        }
		        
		        if(q.empty()){
		            result.push_back('#');
		        }
		        
		    }
		    
		    return result;
		    
		}

};