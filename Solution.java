import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int count = sc.nextInt();
            int[] arr = new int[count];

            for(int j=0; j<count; j++) {
                arr[j] = sc.nextInt();
            }

            System.out.println("ENTERED ARR " +(i+1)+ " : ");
            for(int k : arr) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
