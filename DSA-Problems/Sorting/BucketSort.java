package Sorting;
import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    // Step 1️⃣: Insertion Sort for sorting individual buckets
    // ------------------------------------------
    // Since each bucket will contain only a few elements,
    // insertion sort is efficient for sorting them.
    public static void insertionSort(List<Float> bucket) {
        for (int i = 1; i < bucket.size(); ++i) {
            float key = bucket.get(i);
            int j = i - 1;

            // Move elements greater than 'key' one position ahead
            while (j >= 0 && bucket.get(j) > key) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }

            // Insert the key at its correct position
            bucket.set(j + 1, key);
        }
    }

    // Step 2️⃣: Main Bucket Sort function
    // ------------------------------------------
    // Works best when:
    //  - Input numbers are uniformly distributed in [0, 1)
    //  - Floating-point numbers (e.g., 0.1234, 0.897)
    public static void bucketSort(float[] arr) {
        int n = arr.length;

        if (n <= 0)
            return;

        // Step 2.1️⃣: Create 'n' empty buckets
        // Each bucket will hold elements in a specific value range
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 2.2️⃣: Distribute array elements into buckets
        //
        // The formula (int)(n * arr[i]) maps each value to a bucket index.
        // Example:
        //   arr[i] = 0.565 → n * arr[i] = 6 * 0.565 = 3.39 → index = 3
        // So, arr[i] goes into bucket[3].
        for (int i = 0; i < n; i++) {
            int bi = (int) (n * arr[i]); // bucket index
            buckets[bi].add(arr[i]);
        }

        // Step 2.3️⃣: Sort each individual bucket
        // Since buckets are small, insertion sort is fast and simple here.
        for (int i = 0; i < n; i++) {
            insertionSort(buckets[i]);
        }

        // Step 2.4️⃣: Concatenate all sorted buckets back into arr[]
        // Combine all sorted buckets sequentially to form the final sorted array.
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    // Step 3️⃣: Driver method to test Bucket Sort
    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};

        System.out.println("Original array:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Apply Bucket Sort
        bucketSort(arr);

        System.out.println("\nSorted array is:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}
