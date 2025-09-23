/*Assume I/O Array   A -[ 4,   3,   2,   7,   8,    2,   3,    1   ]
          index -       0     1    2   3    4     5    6      7
		  
				   
				   index                 element                       Todo                               
				    0                      A[0] = 4                   A[4-1] Not negative
					                                                  do it negetive mean we visited 4
																	  array - [4,3,2,-7,8,2,3,1]
																	 
					1                     A[1] = 3                      A[3-1] Not negative
					                                                    do it negetive mean we visited 3
					                                                    array - [4,3,-2,-7,8,2,3,1]
																	  
                   2                      A[2] = 2                      A[2-1] Not negative
				                                                        do it negetive mean we visited 2
																	    array - [4,-3,-2,-7,8,2,3,1]
																	 
				   3                        A[3]=7                      A[7-1] Not negative
				                                                        do it negetive mean we visited 7
																        Array- [4,-3,-2,-7,8,2,-3,1]
																 
				   4                       A[4]=8                      A[8-1] Not negative
				                                                       do it negetive mean we visited 8
																        Array- [4,-3,-2,-7,8,2,-3,-1]
																 
				   5                     A[5]=2                       A[2-1] is Negative Mean It is A 
				                                                      duplicate ele so Put it into ans array  
																     Array- [4,-3,-2,-7,8,2,-3,-1]
																
                    6                   A[6]=3                        A[3-1] is Negative Mean It is A 
                                                                     duplicate ele so Put it into ans array  
                                                                      Array- [4,-3,-2,-7,8,2,-3,-1]
																
					7                  A[7] = 1                     A[1-1] Not negative
					                                                do it negetive mean we visited 1
                                                                     Array- [-4,-3,-2,-7,8,2,-3,-1]
															   
	So we Have {2 , 3 }  <= Here For ans*/

class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        if(nums.empty())return {};
        vector<int>ans;
        for(int i=0;i<nums.size();i++){
            if(nums[abs(nums[i])-1]<0)
                ans.push_back(abs(nums[i]));
            nums[abs(nums[i])-1]=-nums[abs(nums[i])-1];
        }
        return ans;
    }
};


/* Java Solution
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
      
        // Arrays.sort(nums);
        // int k=0,l=nums.length;
        // List<Integer> a= new ArrayList<>();
        // if(l>1){
        //     for(int i=1;i<l;i++){
        //         if(k==0){
        //             if(nums[i-1]==nums[i]){
        //                a.add(nums[i]);
        //                 k++;
        //             }
        //         }else{
        //             if(!(a.get(k-1)==nums[i]) && nums[i-1]==nums[i]){
        //                a.add(nums[i]);
        //                 k++;
        //             }
        //         }
        //     }
        // }
        // return a;  
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
    
        for(int i : nums)
            map.put(i,map.getOrDefault(i,0)+1);
        for(int i : map.keySet())
            if(map.get(i) == 2)
                res.add(i);
        return res;
    }
}
*/