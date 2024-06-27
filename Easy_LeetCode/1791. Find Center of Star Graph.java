class Solution {
    public int findCenter(int[][] e) {
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }
}

//--------------------------------------------

class Solution {

    public int findCenter(int[][] edges) {
        int[] firstEdge = edges[0];
        int[] secondEdge = edges[1];

        return (firstEdge[0] == secondEdge[0] || firstEdge[0] == secondEdge[1])
            ? firstEdge[0]
            : firstEdge[1];
    }
}

// --------------------------------

class Solution {

    public int findCenter(int[][] edges) {
        Map<Integer, Integer> degree = new HashMap<>();

        for (int[] edge : edges) {
            degree.put(edge[0], degree.getOrDefault(edge[0], 0) + 1);
            degree.put(edge[1], degree.getOrDefault(edge[1], 0) + 1);
        }

        for (int node : degree.keySet()) {
            if (degree.get(node) == edges.length) {
                return node;
            }
        }

        return -1;
    }
}