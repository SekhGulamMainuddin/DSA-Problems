// https://leetcode.com/problems/remove-k-balanced-substrings/

public class RemoveKBalancedSubstrings {
    public String removeSubstring(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int open = 0;
        
        for(char c : s.toCharArray()) {
            ans.append(c);
            if(c=='(') {
                open++;
            } else if(ans.length()>=2*k && open>=k) {
                boolean isValid = true;
                for(int i=ans.length()-(2*k); i<ans.length()-k; i++) {
                    if(ans.charAt(i)!='(') {
                        isValid = false;
                        break;
                    }
                }

                for(int i=ans.length()-k; i<ans.length(); i++) {
                    if(ans.charAt(i)!=')') {
                        isValid = false;
                        break;
                    }
                }

                if(isValid) {
                    ans.setLength(ans.length()-2*k);
                    open-=k;
                }
            }
        }

        return ans.toString();
    }
}