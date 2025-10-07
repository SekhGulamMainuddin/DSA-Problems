package Sorting;
import java.util.Arrays;

public class CountingSort {

    public static int[] countSort(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }

        // Step 1️⃣: Find the maximum value in the array
        // This helps us know the range of elements
        int maxVal = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }

        // Step 2️⃣: Create a count array (frequency array)
        // cntArr[i] will store the number of times i appears in arr
        int[] cntArr = new int[maxVal + 1];
        for (int i = 0; i <= maxVal; i++) {
            cntArr[i] = 0;
        }

        // Step 3️⃣: Count the frequency of each element
        for (int i = 0; i < n; i++) {
            cntArr[arr[i]]++;
        }

        // Step 4️⃣: Convert frequency array into a prefix sum array
        //
        // cntArr[i] will now store the **cumulative count** of elements 
        // ≤ i (i.e., total number of elements <= i in the input array).
        //
        // This helps us directly know the *position* of each element 
        // in the final sorted array.
        for (int i = 1; i <= maxVal; i++) {
            cntArr[i] += cntArr[i - 1];
        }

        // Step 5️⃣: Build the output array using the prefix sum logic
        //
        // We iterate from the end of the input array to make the sort **stable**
        // (i.e., elements with the same value appear in the same order as input).
        //
        // cntArr[v] tells us the position (1-based) where value 'v' should go 
        // in the sorted array. After placing it, we decrement cntArr[v]
        // so the next occurrence of the same value goes to the previous slot.
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int v = arr[i];
            ans[cntArr[v] - 1] = v;  // place element in correct sorted position
            cntArr[v]--;              // decrement position for next duplicate
        }

        // Step 6️⃣: Return the sorted array
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] ans = countSort(arr);
        System.out.println(Arrays.toString(ans));
    }
}
