import java.util.*;

// https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1

class KthSmallestElement {
    public int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = l; i < l + k; i++) {
            maxHeap.offer(arr[i]);
        }
        for (int i = l + k; i <= r; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        return maxHeap.peek();
    }
}