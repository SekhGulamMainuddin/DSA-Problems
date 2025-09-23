
// https://www.codingninjas.com/codestudio/problems/build-min-heap_1171167?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

public class BuildMinHeap {

    // Helper method to maintain the min-heap property at index i
    private static void heapify(int[] arr, int i) {
        int smallest = i;              // Assume current node is the smallest
        int left = (2 * i) + 1;        // Index of left child
        int right = (2 * i) + 2;       // Index of right child
        int n = arr.length;

        // If left child exists and is smaller than current smallest
        if (left < n && arr[smallest] > arr[left]) {
            smallest = left;
        }

        // If right child exists and is smaller than current smallest
        if (right < n && arr[smallest] > arr[right]) {
            smallest = right;
        }

        // If the smallest is not the current node, swap and recursively heapify
        if (smallest != i) {
            // Swap current node with the smallest child
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, smallest);
        }
    }

    // Method to build a min-heap from an unsorted array
    public static int[] buildMinHeap(int[] arr) {
        int n = arr.length;

        /*
         * We start from the last non-leaf node and move upwards to the root.
         * - Nodes from index (n/2) to (n-1) are all leaf nodes, and they are already heaps.
         * - The last non-leaf node is at index (n/2 - 1), because:
         *     - For a node at index i, its children are at (2*i + 1) and (2*i + 2).
         *     - So, any index >= n/2 will not have valid children (they're leaves).
         * - We go bottom-up so that when we call heapify on a node, its child subtrees
         *   are already valid heaps.
         */
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, i);
        }

        // Now arr represents a valid min-heap
        return arr;
    }
}
