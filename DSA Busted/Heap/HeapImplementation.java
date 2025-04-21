import java.util.*;

class HeapImplementation {
    int[] arr = new int[101]; // Array to store heap elements (1-based indexing)
    int size;

    public HeapImplementation() {
        size = 0; // Initially the heap is empty
    }

    // Insert a new value into the heap
    public void insert(int val) {
        size++;
        int index = size;
        arr[index] = val;

        // Heapify Up: Restore max-heap property by comparing with parent
        while (index > 1) {
            int parent = index / 2;
            if (arr[index] > arr[parent]) {
                // Swap if current is greater than parent
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;

                index = parent; // Move up
            } else {
                return; // Heap property is satisfied
            }
        }
    }

    // Delete the root (maximum element) from the heap
    public void deleteFromHeap() {
        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }

        // Replace root with last element and reduce size
        arr[1] = arr[size];
        size--;

        // Heapify Down: Restore heap property
        int i = 1;
        while (i <= size) {
            int left = 2 * i;
            int right = 2 * i + 1;
            int largest = i;

            if (left <= size && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right <= size && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest != i) {
                // Swap current with largest child
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                i = largest; // Move down
            } else {
                return; // Heap property satisfied
            }
        }
    }

    // Print all elements in the heap
    public void print() {
        System.out.println();
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        // Manual Max Heap
        HeapImplementation heap = new HeapImplementation();
        heap.insert(55);
        heap.insert(54);
        heap.insert(53);
        heap.insert(50);
        heap.insert(52);
        heap.print();

        heap.deleteFromHeap();
        heap.print();

        // Max Heap using Java's PriorityQueue (default is Min Heap, so we use reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(6);
        maxHeap.add(4);
        maxHeap.add(2);
        maxHeap.add(21);

        System.out.println("Max Heap (PriorityQueue):");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();

        // Min Heap using Java's PriorityQueue (default behavior)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(1);
        minHeap.add(3);
        minHeap.add(6);
        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(21);

        System.out.println("Min Heap (PriorityQueue):");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
    }
}
