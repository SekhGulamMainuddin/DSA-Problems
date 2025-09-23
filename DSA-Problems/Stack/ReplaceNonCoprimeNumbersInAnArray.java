import java.util.*;

class ReplaceNonCoprimeNumbersInAnArray {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();

        for (int num : nums) {
            int curr = num;

            // Keep merging while gcd > 1
            while (!st.isEmpty()) {
                int top = st.peek();
                int gcdValue = gcd(top, curr);
                if (gcdValue == 1)
                    break;

                // Merge into lcm
                curr = lcm(top, curr, gcdValue);
                st.pop();
            }

            st.push(curr);
        }

        // Convert stack to list
        List<Integer> ans = new ArrayList<>(st);
        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b, int gcdValue) {
        return a * (b / gcdValue);
    }
}
