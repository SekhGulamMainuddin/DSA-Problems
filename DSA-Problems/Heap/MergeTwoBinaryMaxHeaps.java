import java.util.*;

// https://practice.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1

class MergeTwoBinaryMaxHeaps {
    public void heapify(int[] arr, int i, int size) {
        int largest = i, left = 2*i + 1, right = 2*i + 2;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]){
            largest = right;
        } 
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, size);
        }
    }

    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int size = n + m;
        
        int[] merged = new int[size];
        
        for(int i=0; i<n; i++) {
            merged[i] = a[i];
        }
        
        for(int i=0; i<m; i++) {
            merged[n+i] = b[i];
        }

        for (int i = size/2 - 1; i >= 0; i--) {
            heapify(merged, i, size);
        }
        return merged;
    }
}