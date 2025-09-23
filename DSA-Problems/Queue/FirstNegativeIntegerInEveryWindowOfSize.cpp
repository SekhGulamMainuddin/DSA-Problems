
// https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

vector<long long> printFirstNegativeInteger(long long int A[],
                                             long long int N, long long int K) {
                                                 
    deque<long long int> dq;
    vector<long long> ans;
    for(long long int i=0; i<K; i++){
        if(A[i]<0){
            dq.push_back(i);
        }
    }
    
    if(dq.empty()){
        ans.push_back(0);
    }else{
        ans.push_back(A[dq.front()]);
    }
    
    for(int i=K; i<N; i++){
        
        if(!dq.empty() && i-dq.front()>=K){
            dq.pop_front();
        }
        
        if(A[i]<0)
            dq.push_back(i);
            
        if(dq.empty()){
            ans.push_back(0);
        }else{
            ans.push_back(A[dq.front()]);
        }
        
    }
    
    return ans;
 }