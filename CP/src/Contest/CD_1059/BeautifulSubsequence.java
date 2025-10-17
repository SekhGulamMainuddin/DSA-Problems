package Contest.CD_1059;

import java.util.ArrayList;
import java.util.Scanner;

class BeautifulSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            String s = sc.next();

            if (isPalindrome(s)) {
                System.out.println(0);
                System.out.println();
                continue;
            }

            boolean found = false;
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j != i) sb.append(s.charAt(j));
                }
                if (isPalindrome(sb.toString())) {
                    System.out.println(1);
                    System.out.println(i + 1);
                    found = true;
                    break;
                }
            }

            if (!found) {
                ArrayList<Integer> pIndices = new ArrayList<>();
                char last = '0' - 1;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) >= last) {
                        pIndices.add(i + 1);
                        last = s.charAt(i);
                    }
                }
                System.out.println(pIndices.size());
                for (int idx : pIndices) {
                    System.out.print(idx + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
