
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class Solution {
    public String removeDuplicates(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }
}

//using stack
// import java.util.Stack;
// class Solution {
//     public String removeDuplicates(String s) {
//         Stack<Character> stack=new Stack<>();
//         for(int i=0;i<s.length();i++){

//             if(stack.isEmpty()){
//                 stack.push(s.charAt(i));
//             }else{
//                 if(s.charAt(i)==stack.peek()){
//                     stack.pop();
//                 }else{
//                     stack.push(s.charAt(i));
//                 }
//             }

//         }
//         s="";

//         while(!stack.isEmpty()){
//             s=stack.pop()+s;
//         }
//         return s;
//     }
// }