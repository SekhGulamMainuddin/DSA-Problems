import java.util.*;

// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

class SmallestRangeCoveringElementsFromKLists {

    /*
     * Problem:
     * Given k sorted lists of integers, find the smallest range that includes at least one element from each of the k lists.
     * 
     * Approach:
     * - Use a min-heap (priority queue) to always access the smallest current element.
     * - Track the maximum value among the current elements.
     * - At every step, calculate the range [min, max].
     * - Update the result if this range is smaller than the previous best.
     * - Replace the smallest element with the next element from the same list.
     * - Stop when any list runs out of elements.
     * 
     * Time Complexity: O(N * log k)
     *   - N: total number of elements across all lists
     *   - k: number of lists (heap operations are O(log k))
     * 
     * Space Complexity: O(k)
     *   - Heap stores one element from each of the k lists
     */

    // Node class to store element value and its position (row = list index, col = index in the list)
    static class Node implements Comparable<Node> {
        final int data; // actual number
        final int row;  // index of the list the number belongs to
        final int col;  // index in the list

        Node(int data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
        }

        // Sorting Nodes based on their data value (min-heap behavior)
        @Override
        public int compareTo(Node other) {
            return this.data - other.data;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        /*
         * Min-heap to get the current minimum element across all lists
         */
        PriorityQueue<Node> q = new PriorityQueue<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = nums.size(); // number of lists

        /*
         * Step 1: Initialize the heap with the first element of each list
         * Also keep track of the current maximum element
         */
        for (int i = 0; i < n; i++) {
            int value = nums.get(i).get(0);
            min = Math.min(min, value);
            max = Math.max(max, value);
            q.offer(new Node(value, i, 0)); // push first element from each list
        }

        // Initialize answer range
        int ansMin = min;
        int ansMax = max;

        /*
         * Step 2: Start processing elements from the heap
         */
        while (!q.isEmpty()) {
            // Get the minimum element (current smallest across lists)
            Node node = q.poll();

            // Calculate the current range
            int diff = max - node.data;
            int ansDiff = ansMax - ansMin;

            // Update the answer if we found a smaller range
            if (diff < ansDiff) {
                ansMin = node.data;
                ansMax = max;
            }

            /*
             * Step 3: Try to move forward in the same list from which the minimum element came
             * If we can, add the next element to the heap and update max
             * If we can't, break out as we can't cover all lists anymore
             */
            if (node.col + 1 < nums.get(node.row).size()) {
                int nextVal = nums.get(node.row).get(node.col + 1);
                q.offer(new Node(nextVal, node.row, node.col + 1)); // push next element from the same list
                max = Math.max(max, nextVal); // update current max
            } else {
                // If we reach the end of any list, we cannot form a valid range anymore
                break;
            }
        }

        // Return the smallest range found
        return new int[] { ansMin, ansMax };
    }
}