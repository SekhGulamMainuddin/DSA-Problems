import java.util.*;

public class UnconventionalPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int maxDiff = 0;
            for (int i = 0; i < n; i += 2) {
                maxDiff = Math.max(maxDiff, arr[i+1] - arr[i]);
            }

            System.out.println(maxDiff);
        }
        sc.close();
    }
}
