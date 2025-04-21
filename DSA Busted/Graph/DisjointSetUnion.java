// Disjoint Set Union (Union-Find) using Rank and Size in one file

// Using Union by Rank
class DisjointSetRank {
    int[] parent;
    int[] rank;

    public DisjointSetRank(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findUltimateParent(int x) {
        if (parent[x] != x) {
            parent[x] = findUltimateParent(parent[x]); // Path Compression
        }
        return parent[x];
    }

    public void unionByRank(int x, int y) {
        int rootX = findUltimateParent(x);
        int rootY = findUltimateParent(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}

// Using Union by Size
class DisjointSetSize {
    int[] parent;
    int[] size;

    public DisjointSetSize(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUltimateParent(int x) {
        if (parent[x] != x) {
            parent[x] = findUltimateParent(parent[x]); // Path Compression
        }
        return parent[x];
    }

    public void unionBySize(int x, int y) {
        int rootX = findUltimateParent(x);
        int rootY = findUltimateParent(y);

        if (rootX == rootY) return;

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
}

// Test class
public class DisjointSetUnion {
    public static void main(String[] args) {
        System.out.println("=== Union by Rank ===");
        DisjointSetRank dsRank = new DisjointSetRank(5);
        dsRank.unionByRank(0, 1);
        dsRank.unionByRank(1, 2);
        System.out.println("0 and 2 connected? " + (dsRank.findUltimateParent(0) == dsRank.findUltimateParent(2)));
        dsRank.unionByRank(3, 4);
        System.out.println("0 and 4 connected? " + (dsRank.findUltimateParent(0) == dsRank.findUltimateParent(4)));
        for (int i = 0; i < 5; i++) {
            System.out.println("Node " + i + " → Parent: " + dsRank.findUltimateParent(i));
        }

        System.out.println("\n=== Union by Size ===");
        DisjointSetSize dsSize = new DisjointSetSize(5);
        dsSize.unionBySize(0, 1);
        dsSize.unionBySize(1, 2);
        System.out.println("0 and 2 connected? " + (dsSize.findUltimateParent(0) == dsSize.findUltimateParent(2)));
        dsSize.unionBySize(3, 4);
        System.out.println("0 and 4 connected? " + (dsSize.findUltimateParent(0) == dsSize.findUltimateParent(4)));
        for (int i = 0; i < 5; i++) {
            System.out.println("Node " + i + " → Parent: " + dsSize.findUltimateParent(i));
        }
    }
}
