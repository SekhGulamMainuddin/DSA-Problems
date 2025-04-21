
// https://practice.geeksforgeeks.org/problems/heap-sort/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class HeapSort {

    // Helper method to maintain the max-heap property
    private void heapify(int arr[], int i, int n) {
        int largest = i; // Assume current node is the largest
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If left child exists and is greater than current largest
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child exists and is greater than current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest is not the current node, swap and heapify the affected subtree
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, largest, n);
        }
    }

    // Build a max heap from the input array
    private void buildMaxHeap(int arr[], int n) {
        // Start from last non-leaf node and move upwards
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    // Main method to perform heap sort
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Step 1: Build a max heap
        buildMaxHeap(arr, n);

        // Step 2: One by one extract elements from heap
        for (int i = arr.length - 1; i >= 1; i--) {
            // Move current root (max element) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Reduce heap size and heapify the root again
            heapify(arr, 0, i);
        }
    }

    // Utility method to print the array
    public void printArray(int arr[]) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        HeapSort sorter = new HeapSort();
        int[] arr = {10, 5, 20, 2, 4, 8, 18};

        System.out.println("Original Array:");
        sorter.printArray(arr);

        sorter.heapSort(arr);

        System.out.println("Sorted Array (Ascending Order):");
        sorter.printArray(arr);
    }
}
