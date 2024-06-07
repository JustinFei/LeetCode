class Solution { // O{n ^2 lg n}
    public int createSortedArray(int[] instructions) {
        int mod = (int)1e9 + 7;
        List<Integer> list = new ArrayList<>();
        int cost = 0;
        for (int i = 0; i < instructions.length; i++) {
            int index = binSearchMin(instructions[i], list);
            cost = (cost + Math.min(index, i - binSearchMax(instructions[i], list))) % mod;
            list.add(index, instructions[i]);
        }
        return cost;
    }
    
    private int binSearchMin(int target, List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if(list.get(m) >= target) {
                  r = m;
            } else {
                l = m + 1;
            }
        }
        
        return list.get(r) < target ? r + 1 : r;
    }
                
     public int binSearchMax(int target, List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        int l = 0;
        int r = list.size() - 1;
        
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(list.get(mid) > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return list.get(r) <= target ? r + 1 : r;
    }
}

//-------------

/* 
    Binary Indexed Tree.

    Time O(NlogM),
    Space O(M)
    where M is the range of A[i].
*/
class Solution {
    int[] c;
    public int createSortedArray(int[] A) {
        int res = 0, n = A.length, mod = (int)1e9 + 7;
        c = new int[100001];
        for (int i = 0; i < n; ++i) {
            res = (res + Math.min(get(A[i] - 1), i - get(A[i]))) % mod;
            update(A[i]);
        }
        return res;
    }

    public void update(int x) {
        while (x < 100001) {
            c[x]++;
            x += x & -x;
        }
    }

    public int get(int x) {
        int res = 0;
        while (x > 0) {
            res += c[x];
            x -= x & -x;
        }
        return res;
    }
}