class Solution {
    public int maxWidthRamp(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;

        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i: B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }
}

//-----------------------
class Solution {
     public int maxWidthRamp(int[] A) {
        List<Integer> s = new ArrayList<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            if (s.size() == 0 || A[i] < A[s.get(s.size() - 1)]) {
                s.add(i);
            } else {
                int left = 0, right = s.size() - 1, mid = 0;
                while (left < right) {
                    mid = (left + right) / 2;
                    if (A[s.get(mid)] > A[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                res = Math.max(res, i - s.get(left));
            }
        }
        return res;
    }
}