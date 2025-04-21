import java.util.*;

// https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

class MinimumCostOfRopes {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : arr) pq.offer(rope);

        int cost = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            cost += a + b;
            pq.offer(a + b);
        }

        return cost;
    }
}