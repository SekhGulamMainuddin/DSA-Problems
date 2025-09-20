// https://leetcode.com/problems/implement-router/

import java.util.*;

public class ImplementRouter {
    HashSet<Long> packetSet = new HashSet<>();
    HashMap<Integer, ArrayList<int[]>> destinationMap = new HashMap<>();
    Queue<int[]> queue = new LinkedList<>();
    int memoryLimit;

    public ImplementRouter(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        long packet = makeKey(source, destination, timestamp);
        if(!packetSet.contains(packet)) {
            packetSet.add(packet);
            int[] packetObject = new int[]{source, destination, timestamp};
            queue.add(packetObject);
            ArrayList<int[]> destinationList = destinationMap.getOrDefault(destination, new ArrayList<>());
            destinationList.add(packetObject);
            destinationMap.putIfAbsent(destination, destinationList);
            if(queue.size()>memoryLimit) {
                forwardPacket();
            }
            return true;
        }
        return false;
    }

    // Encode packet to a unique long
    private long makeKey(int s, int d, int t) {
        return (long)s * 10000000000L + (long)d * 100000 + t;
    }
    
    public int[] forwardPacket() {
        if(queue.isEmpty()) {
            return new int[]{};
        }
        int[] packetObject = queue.poll();
        destinationMap.get(packetObject[1]).remove(0);
        packetSet.remove(makeKey(packetObject[0], packetObject[1], packetObject[2]));
        return packetObject;
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        if(!destinationMap.containsKey(destination)) {
            return 0;
        }
        ArrayList<int[]> list = destinationMap.get(destination);
        int startIndex = Integer.MAX_VALUE;
        int endIndex = Integer.MIN_VALUE;

        int lb=0, ub=list.size()-1, mid = (lb+ub)/2;
        
        /// Start Index Binary Search Loop
        while(lb<=ub) {
            mid = (lb+ub)/2;
            int time = list.get(mid)[2];
            if(time>startTime) {
                startIndex = mid;
                ub = mid-1;
            } else if (time==startTime) {
                startIndex=mid;
                ub = mid-1;
            } else {
                lb=mid+1;
            }
        }

        lb=0;
        ub=list.size()-1;
        mid = (lb+ub)/2;
        /// End Index Binary Search Loop
        while(lb<=ub) {
            mid = (lb+ub)/2;
            int time = list.get(mid)[2];
            if(time<endTime) {
                endIndex = mid;
                lb = mid+1;
            } else if (time==endTime) {
                endIndex=mid;
                lb = mid+1;
            } else {
                ub=mid-1;
            }
        }

        if(startIndex==Integer.MAX_VALUE || endIndex==Integer.MIN_VALUE) {
            return 0;
        }

        return endIndex-startIndex+1;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */