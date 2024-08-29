// ----------DFS O(n2) O(n2)

class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;

        // Adjacency list to store graph connections
        List<Integer>[] adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Build the graph: Connect stones that share the same row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjacencyList[i].add(j);
                    adjacencyList[j].add(i);
                }
            }
        }

        int numOfConnectedComponents = 0;
        boolean[] visited = new boolean[n];

        // Traverse all stones using DFS to count connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirstSearch(adjacencyList, visited, i);
                numOfConnectedComponents++;
            }
        }

        // Maximum stones that can be removed is total stones minus number of connected components
        return n - numOfConnectedComponents;
    }

    // DFS to visit all stones in a connected component
    private void depthFirstSearch(
        List<Integer>[] adjacencyList,
        boolean[] visited,
        int stone
    ) {
        visited[stone] = true;

        for (int neighbor : adjacencyList[stone]) {
            if (!visited[neighbor]) {
                depthFirstSearch(adjacencyList, visited, neighbor);
            }
        }
    }
}

// ----------Union-Find O(n) O(n)----------------------

class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);

        // Populate uf by connecting stones that share the same row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (
                    stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]
                ) {
                    uf.union(i, j);
                }
            }
        }

        return n - uf.count;
    }

    // Union-Find data structure for tracking connected components
    private class UnionFind {

        int[] parent; // Array to track the parent of each node
        int count; // Number of connected components

        UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1); // Initialize all nodes as their own parent
            count = n; // Initially, each stone is its own connected component
        }

        // Find the root of a node with path compression
        int find(int node) {
            if (parent[node] == -1) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        // Union two nodes, reducing the number of connected components
        void union(int n1, int n2) {
            int root1 = find(n1);
            int root2 = find(n2);

            if (root1 == root2) {
                return; // If they are already in the same component, do nothing
            }

            // Merge the components and reduce the count of connected components
            count--;
            parent[root1] = root2;
        }
    }
}

// --------------------------

class Solution {

    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;

    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; i++)
            union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }
}