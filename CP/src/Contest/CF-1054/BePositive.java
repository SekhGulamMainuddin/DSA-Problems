import java.util.Scanner;

public class BePositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.nextLine();
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int size = sc.nextInt();
            sc.nextLine();
            String[] arr = sc.nextLine().split(" ");
            int currAns = 0;
            int minNegative = 0;
            int negativeCount = 0;
            for(String s : arr) {
                int value = Integer.parseInt(s);
                if(value==0) {
                    currAns++;
                } else if (value<0) {
                    negativeCount++;
                    minNegative = Math.min(minNegative, value);
                }
            }

            if(negativeCount%2!=0) {
                currAns+=minNegative*-1;
                currAns++;
            }
            ans[i] = currAns;
        }

        for(int i : ans) {
            System.out.println(i);
        }

        sc.close();
    }    
}
