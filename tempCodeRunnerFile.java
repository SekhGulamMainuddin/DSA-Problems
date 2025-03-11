import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();
        char[][] cArr = new char[h][w];

        for(int i=0; i<h; i++) {
            String s = sc.nextLine();
            cArr[i] = s.toCharArray();
        }

        System.out.println("\nValues->" + h + " " + w + " " + k);

        for(int i=0; i<h; i++) {
            for(char c : cArr[i]) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
