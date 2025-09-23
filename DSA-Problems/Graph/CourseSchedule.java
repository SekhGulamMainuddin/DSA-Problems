import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule/

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) {
            return true;
        }
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            adj.put(i, new ArrayList<Integer>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            ArrayList<Integer> adjacentEdges = adj.get(prerequisites[i][1]);
            adjacentEdges.add(prerequisites[i][0]);
            adj.put(prerequisites[i][1], adjacentEdges);

            // Calculated Indegree here only
            inDegree[prerequisites[i][0]]++;
        }

        // for(int i=0; i<numCourses; i++) {
        //     for(int j : adj.get(i)) {
        //         inDegree[j]++;
        //     }
        // }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(inDegree[i]==0) {
                q.add(i);
            }
        }

        int count = 0;
        
        while(!q.isEmpty()) {
            int i = q.poll();
            count++;
            for(int neighbour : adj.getOrDefault(i, new ArrayList<>())) {
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0) {
                    q.add(neighbour);
                }
            }
        }

        return count == numCourses;
    }
}