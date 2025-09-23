import java.util.*;

// https://www.codingninjas.com/codestudio/problems/k-th-largest-sum-contiguous-subarray_920398?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

public class KthLargestSumSubArray {
    public static int getKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (minHeap.size() < k) {
                    minHeap.offer(sum);
                } else if (sum > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(sum);
                }
            }
        }

        return minHeap.peek();
    }
}