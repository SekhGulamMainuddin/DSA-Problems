import java.util.* ;

public class RedundantBrackets
{
    public static boolean findRedundantBrackets(String s) 
    {
        Stack<Character> st = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '*' || ch == '-' || ch == '/' || ch == '+') {
                st.push(ch);
            } else if (ch == ')') {
                boolean isRedundant = true;

                // Process until '(' is found
                while (!st.isEmpty() && st.peek() != '(') {
                    char c = st.peek();
                    if (c == '*' || c == '-' || c == '/' || c == '+') {
                        isRedundant = false;
                    }
                    st.pop();
                }

                // Remove '(' from the stack
                st.pop();

                if (isRedundant) {
                    return true;
                }
            }
        }
        return false;
    }
}
