package CP.src.StriverCPSheet.ImplementationConstructive;

import java.util.Scanner;

public class BitPlusPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        for(int i=0; i<n; i++) {
            String exp = sc.next();
            char start = exp.charAt(0);
            char end = exp.charAt(2);
            if(start=='+' || end =='+') {
                x++;
            } else {
                x--;
            }
        }
        System.out.println(x);
    }
    
}
