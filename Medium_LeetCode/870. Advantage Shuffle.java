class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int n = A.length;
        int[] res = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for (int i = 0; i < n; i++) pq.add(new int[]{B[i], i});
        int lo = 0, hi = n - 1;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int idx = cur[1], val = cur[0];
            if (A[hi] > val) res[idx] = A[hi--];
            else res[idx] = A[lo++];
        }
        return res;
    }  
}

// Shorter version just for fun (promise me never use it during an interview):
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for (int i = 0; i < B.length; i++) pq.add(new int[]{B[i], i});
        int lo = 0, hi = A.length - 1, res[] = new int[A.length];
        while(!pq.isEmpty()) res[pq.peek()[1]] = pq.poll()[0] < A[hi] ? A[hi--] : A[lo++];
        return res;
    }
}

//-----------------------------
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for (int n: A) {
            tm.put(n, tm.getOrDefault(n, 0) + 1);
        }
        
        int[] res = new int[A.length];
        
        for (int i = 0; i < A.length; i++) {
            Integer x = tm.higherKey(B[i]);
            if (x == null) {
                x = tm.firstKey();
            }
            int cur = tm.get(x);
            if (cur == 1) {
                tm.remove(x);
            } else {
                tm.put(x, cur - 1);
            }
            res[i] = x;
        }
        return res;
    }
}