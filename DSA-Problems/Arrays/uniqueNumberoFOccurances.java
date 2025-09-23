
//https://leetcode.com/problems/unique-number-of-occurrences/submissions/
import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        Set<Integer> s= new HashSet<>(map.values());
        return s.size()==map.size();
    }
}