// https://leetcode.com/problems/design-task-manager/

import java.util.*;

public class DesignTaskManager {
    // Pair class to hold task details: taskId, priority, and userId
    static class Pair implements Comparable<Pair> {
        int priority;
        int taskId;
        int userId;

        Pair(int priority, int taskId, int userId) {
            this.priority = priority;
            this.taskId = taskId;
            this.userId = userId;
        }

        // Define ordering for PriorityQueue (max-heap behavior)
        @Override
        public int compareTo(Pair o) {
            // Higher priority first
            if (this.priority != o.priority) {
                return o.priority - this.priority;
            }
            // If same priority, higher taskId first
            return o.taskId - this.taskId;
        }
    }

    // Max heap of tasks (lazy deletion handled in execTop)
    private PriorityQueue<Pair> pq;
    // Map to keep track of the latest valid priority for each task
    private Map<Integer, Integer> taskPriority;
    // Map to store the owner (userId) of each task
    private Map<Integer, Integer> taskOwner;

    // Constructor initializes with given tasks
    public DesignTaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>();  // uses Pair.compareTo for ordering
        taskPriority = new HashMap<>();
        taskOwner = new HashMap<>();
        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    // Add a new task to the system
    public void add(int userId, int taskId, int priority) {
        pq.add(new Pair(priority, taskId, userId));
        taskPriority.put(taskId, priority);   // store latest priority
        taskOwner.put(taskId, userId);        // store user owning this task
    }

    // Edit an existing task's priority (lazy add to heap)
    public void edit(int taskId, int newPriority) {
        pq.add(new Pair(newPriority, taskId, taskOwner.get(taskId)));
        taskPriority.put(taskId, newPriority);
    }

    // Remove a task (mark as invalid by priority = -1)
    public void rmv(int taskId) {
        taskPriority.put(taskId, -1);
    }

    // Execute and remove the top valid task
    public int execTop() {
        while (!pq.isEmpty()) {
            Pair t = pq.poll(); // take current top candidate
            int p = t.priority, id = t.taskId;
            // Check if this entry is still valid (not outdated/removed)
            if (taskPriority.getOrDefault(id, -1) == p) {
                taskPriority.put(id, -1); // mark as executed
                return taskOwner.get(id);
            }
        }
        return -1; // no valid tasks left
    }
}
