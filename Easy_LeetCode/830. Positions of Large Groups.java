class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        char[] array = S.toCharArray();
        if (array.length < 2) {
            return res;
        }
        while (end < array.length) {
            if (array[start] == array[end]) {
                end++;
            } else {
                if ((end - start) > 2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end - 1);
                    res.add(list);
                }
                start = end;
            }
        }
        if (start != end - 1 && array[start] == array[end - 1] && end - start > 2) {
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end - 1);
            res.add(list);
        }
        return res;
    }
}

---------------------------------------
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N - 1 || S.charAt(j) != S.charAt(j + 1)) {
                // Here, [i, j] represents a group.
                if (j - i + 1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }

        return ans;
    }
}