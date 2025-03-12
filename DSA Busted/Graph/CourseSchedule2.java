import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/

class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int[] subjects : prerequisites) {
            adj.get(subjects[1]).add(subjects[0]);
        }

        int[] inDegree = new int[numCourses];
        for (ArrayList<Integer> dependencies : adj) {
            for (int subject : dependencies) {
                inDegree[subject]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int sub = q.poll();
            ans.add(sub);

            for (int depSub : adj.get(sub)) {
                inDegree[depSub]--;
                if (inDegree[depSub] == 0) {
                    q.add(depSub);
                }
            }
        }
        if (ans.size() != numCourses) {
            return new int[] {};
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}