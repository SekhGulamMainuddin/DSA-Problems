import java.util.*;

// https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

class MergeKSortedArrays {
    static class Node {
        int data, i, j;
        Node(int data, int i, int j) {
            this.data = data;
            this.i = i;
            this.j = j;
        }
    }

    static class Compare implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.data - b.data;
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            pq.offer(new Node(arr[i][0], i, 0));
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            result.add(node.data);
            int nextIndex = node.j + 1;
            if (nextIndex < arr[node.i].length) {
                pq.offer(new Node(arr[node.i][nextIndex], node.i, nextIndex));
            }
        }

        return result;
    }
}