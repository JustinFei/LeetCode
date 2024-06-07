
class Solution { // BFS
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            if (arr[node] == 0) {
                return true;
            }
            if (visited[node] == true) {
                continue;
            }
            if (node + arr[node] < n) {
                q.offer(node + arr[node]);
            }
            
            if (node - arr[node] >= 0) {
                q.offer(node - arr[node]);
            }
            
            visited[node] = true;
        }
        return false;
    }
}

// -----------------------------------------

class Solution { // DFS
    public boolean canReach(int[] arr, int start) {
        if (start >= arr.length) {
            return false;
        }
        boolean[] visited = new boolean[arr.length];
        return canReach(arr, start, visited);
    }
    
    private boolean canReach(int[] arr, int start, boolean[] visited) {
        if (start < 0 || start >= arr.length || visited[start]) {
            return false;
        }
        visited[start] = true;
        return arr[start] == 0 || canReach(arr, start + arr[start], visited) || canReach(arr, start - arr[start], visited);
    }
}