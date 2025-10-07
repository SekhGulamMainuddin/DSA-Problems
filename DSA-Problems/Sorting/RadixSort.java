package Sorting;
// Radix Sort Java Implementation with Detailed Comments

import java.util.*;

class RadixSort {

    // Step 1️⃣: Utility function to get the maximum value in the array.
    // This tells us how many digits the largest number has.
    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // Step 2️⃣: A stable Counting Sort based on a specific digit (exp)
    //
    // Here, exp = 1 for units place, 10 for tens place, 100 for hundreds, etc.
    // For each digit position, we use Counting Sort to group numbers based on that digit.
    static void countSort(int arr[], int n, int exp) {
        int[] output = new int[n];  // Output array (holds sorted result for current digit)
        int[] count = new int[10];  // Because digits range from 0–9

        Arrays.fill(count, 0);  // Initialize count array with zeros

        // Step 2.1️⃣: Count occurrences of each digit in this digit position
        //
        // (arr[i] / exp) % 10 extracts the digit at the current place.
        // Example: if arr[i]=802 and exp=10 → (802/10)%10 = 0 (tens digit)
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Step 2.2️⃣: Convert frequency counts to prefix sums (cumulative counts)
        //
        // count[i] will now represent the actual position (1-based index)
        // of the *last occurrence* of digit i in the output array.
        //
        // Example:
        //  count[] before prefix: [1, 2, 0, 1, 0, ...]
        //  count[] after prefix:  [1, 3, 3, 4, 4, ...]
        //  → means: digit 0 ends at pos 1, digit 1 ends at pos 3, digit 3 ends at pos 4, etc.
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Step 2.3️⃣: Build the output array in reverse order
        //
        // We go from right to left to make the sort **stable**.
        // Stability means that numbers with the same digit will
        // appear in the same relative order as in the original array.
        //
        // For each number:
        //   - Find its current digit
        //   - Place it in output[count[digit] - 1]
        //   - Decrement count[digit] to handle the next occurrence of that digit
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Step 2.4️⃣: Copy the output array back into the input array
        // Now arr[] is sorted by the current digit (exp)
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // Step 3️⃣: The main Radix Sort function
    static void radixsort(int arr[], int n) {
        // Find the maximum number to determine number of digits
        int m = getMax(arr, n);

        // Perform Counting Sort for each digit position.
        //
        // exp = 1 → units place
        // exp = 10 → tens place
        // exp = 100 → hundreds place, etc.
        //
        // Loop continues while (m / exp > 0), i.e., until we’ve processed all digits.
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // Step 4️⃣: Utility function to print the array
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Step 5️⃣: Main method — driver code
    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;

        System.out.println("Original Array:");
        print(arr, n);
        System.out.println();

        // Perform Radix Sort
        radixsort(arr, n);

        System.out.println("Sorted Array:");
        print(arr, n);
    }
}
