  
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution {
    public void solve(String digits, StringBuilder output, int index, List<String> ans, String[] mapping) {
        if (index >= digits.length()) {
            ans.add(output.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String values = mapping[digit];

        for (int i = 0; i < values.length(); i++) {
            output.append(values.charAt(i)); // Append character
            solve(digits, output, index + 1, ans, mapping);
            output.deleteCharAt(output.length() - 1); // Backtrack
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        StringBuilder output = new StringBuilder();
        int index = 0;
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(digits, output, index, ans, mapping);
        return ans;
    }
}
