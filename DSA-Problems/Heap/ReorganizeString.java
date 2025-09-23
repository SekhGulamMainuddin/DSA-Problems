// https://leetcode.com/problems/reorganize-string/

class ReorganizeString {
    static class Pair implements Comparable<Pair> {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Pair p) {
            return Integer.compare(p.count, this.count); // max-heap
        }
    }

    public String reorganizeString(String s) {
        int n = s.length();
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        if (maxHeap.peek().count > (n + 1) / 2) {
            return ""; // not possible
        }

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() >= 2) {
            Pair p1 = maxHeap.poll();
            Pair p2 = maxHeap.poll();

            sb.append(p1.c);
            sb.append(p2.c);

            if (--p1.count > 0) maxHeap.offer(p1);
            if (--p2.count > 0) maxHeap.offer(p2);
        }

        if (!maxHeap.isEmpty()) {
            sb.append(maxHeap.poll().c);
        }

        return sb.toString();
    }
}
