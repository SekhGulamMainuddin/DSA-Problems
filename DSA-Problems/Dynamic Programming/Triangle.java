// https://leetcode.com/problems/triangle

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        /// Top Down Approach
        // for(int i=1; i<triangle.size(); i++) {
        //     for(int j=0; j<triangle.get(i).size(); j++) {
        //         int currValue = triangle.get(i).get(j);
        //         boolean isChanged = false;
        //         if(j!=0) {
        //             triangle.get(i).set(j, triangle.get(i-1).get(j-1)+currValue);
        //             isChanged = true;
        //         }
                
        //         if(j<triangle.get(i-1).size()) {
        //             int value=triangle.get(i-1).get(j)+currValue;
        //             if(isChanged) {
        //                 triangle.get(i).set(j, Math.min(value, triangle.get(i).get(j)));
        //             } else {
        //                 triangle.get(i).set(j, value);
        //             }    
        //         }
        //     }
        // }

        // int min = Integer.MAX_VALUE;

        // for(int i=0; i<triangle.get(triangle.size()-1).size(); i++) {
        //     min = Math.min(triangle.get(triangle.size()-1).get(i), min);
        // }
        // return min;

        /// Bottom Up Approach
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int down = triangle.get(i+1).get(j);
                int downRight = triangle.get(i+1).get(j+1);
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(down, downRight));
            }
        }
        return triangle.get(0).get(0);
    }
}