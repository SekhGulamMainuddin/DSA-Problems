
// https://practice.geeksforgeeks.org/problems/ec277982aea7239b550b28421e00acbb1ea03d2c/1

class Solution {
  public:
    vector<int> maximumValue(Node* root) {
        //code here
        vector<int> ans;
        
        queue<Node*> q;
        q.push(root);
        int maxValueInLevel= INT_MIN;
        while(!q.empty()){
            
            maxValueInLevel= INT_MIN;
            int size= q.size();
            for(int i=0; i<size; i++){
                Node* tempNode= q.front();
                q.pop();
                
                if(tempNode->data>maxValueInLevel)
                    maxValueInLevel= tempNode->data;
                
                if(tempNode->left)
                    q.push(tempNode->left);
                if(tempNode->right)
                    q.push(tempNode->right);
                
            }
            
            ans.push_back(maxValueInLevel);
            
        }
        
        return ans;
        
    }
};




