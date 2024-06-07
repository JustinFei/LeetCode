class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] array = new int[n * n];
        int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[x++] = matrix[i][j];
            }
        }
        Arrays.sort(array);
        return array[k - 1];
    }
}

// -----------------------------
class Solution {
    static class Node {
        int x;
        int y;
        int v;
        Node(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        PriorityQueue<Node> heap = new PriorityQueue<>(11, new Comparator<Node>() {
           @Override
            public int compare(Node a, Node b) {
                if (a.v == b.v) {
                    return 0;
                }
                return a.v < b.v ? -1: 1;
            }
        });
        for (int i = 0; i < n; i++) {
           heap.offer(new Node(i, 0, matrix[i][0]));
        }
        for (int i = 0; i < k - 1; i++) {
            Node tmp = heap.poll();
            if (tmp.y + 1 < n) {
                heap.offer(new Node(tmp.x, tmp.y + 1, matrix[tmp.x][tmp.y + 1]));
            }
        }
        return heap.peek().v;
    }
}   

// -----------------------------------

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}