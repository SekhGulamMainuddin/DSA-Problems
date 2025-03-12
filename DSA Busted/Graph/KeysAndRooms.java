import java.util.*;

// https://leetcode.com/problems/keys-and-rooms

class KeysAndRooms {
    private void dfs(List<List<Integer>> rooms, boolean[] visited, int node) {
        visited[node] = true;

        for(int i : rooms.get(node)) {
            if(!visited[i]) {
                dfs(rooms, visited, i);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        dfs(rooms, visited, 0);

        for(int i=0; i<rooms.size(); i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }
}