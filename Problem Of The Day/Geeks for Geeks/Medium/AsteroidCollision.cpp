
// https://practice.geeksforgeeks.org/problems/asteroid-collision/1

class Solution {
  public:
       vector<int> asteroidCollision(int N, vector<int> &asteroids) {
        stack <int> st;
        for(int i=0;i<asteroids.size();i++){
            if(asteroids[i] > 0)
                st.push(asteroids[i]);
            else{
                bool flag = false;
                while(!st.empty()){
                    if(st.top() < 0){
                        st.push(asteroids[i]);
                        break;
                    }
                    else if (st.top() < -1 * asteroids[i])
                        st.pop();
                    else
                        break;
                }
                /*
                    This should happen only once
                    Consider the case when stack has ... 5 5 5 and asteroids[i] = -5
                    The extreme 5 and -5 collide and explode but the other two 5's will not have any impact
                    Stack will be ... 5 5
                */
                if(!st.empty() && st.top() == -1 * asteroids[i])
                    st.pop();
                /*
                    When stack is empty and the value is negative
                    It has to be pushed to the stack.
                */
                if(st.empty())
                    st.push(asteroids[i]);
            }
        }
        vector <int> res;
        while(!st.empty()){
            res.push_back(st.top());
            st.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
    
    
    vector <int> recursive(vector<int>& res, stack <int> st){
    if(st.empty())
        return res;
    int curr_value = st.top();
    st.pop();
   // Recursively reaching the bottom of the stack
    recursive(res, st);
    res.push_back(curr_value);
    return res;
}
    // vector<int> asteroidCollision(int N, vector<int> &asteroids) {
    //     stack <int> st;
    //     for(int i=0;i<asteroids.size();i++){
    //         if(asteroids[i] > 0)
    //             st.push(asteroids[i]);
    //         else{
    //             bool flag = false;
    //             while(!st.empty()){
    //                 if(st.top() < 0){
    //                     st.push(asteroids[i]);
    //                     break;
    //                 }
    //                 else if (st.top() < -1 * asteroids[i])
    //                     st.pop();
    //                 else
    //                     break;
    //             }
    //             /*
    //                 This should happen only once
    //                 Consider the case when stack has ... 5 5 5 and asteroids[i] = -5
    //                 The extreme 5 and -5 collide and explode but the other two 5's will not have any impact
    //                 Stack will be ... 5 5
    //             */
    //             if(!st.empty() && st.top() == -1 * asteroids[i])
    //                 st.pop();
    //             /*
    //                 When stack is empty and the value is negative
    //                 It has to be pushed to the stack.
    //             */
    //             if(st.empty())
    //                 st.push(asteroids[i]);
    //         }
    //     }
    //     vector <int> res;
    //     return recursive(res, st);
    // }
    
};