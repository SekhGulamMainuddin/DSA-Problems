import java.util.Scanner;

public class BeautifulAverage {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            int length = sc.nextInt();
            int[] arr = new int[length];
            for(int j=0; j<length; j++) {
                arr[j] = sc.nextInt();
            }

            int maxAverage = 0;

            for(int j=0; j<length; j++) {
                int sum = 0;
                int l = 0;
                for(int k=j; k<length; k++) {
                    sum+=arr[k];
                    l++;
                    int average = sum/l;
                    maxAverage = Math.max(maxAverage, average);
                }
            }

            ans[i] = maxAverage;
        }

        for(int a : ans) {
            System.out.println(a);
        }
    }
}