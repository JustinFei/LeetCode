class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int rows = img1.length, cols = img1[0].length;
        List<int[]> la = new ArrayList<>(), lb = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (img1[r][c] == 1) la.add(new int[]{r, c});
                if (img2[r][c] == 1) lb.add(new int[]{r, c});
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for (int[] pa : la) {
            for (int[] pb : lb) {
                String s = (pa[0] - pb[0]) + " " + (pa[1] - pb[1]);
                map.put(s, map.getOrDefault(s, 0) + 1); 
            }
        }

        int max = 0;
        for (int c : map.values()) {
            max = Math.max(max, c);
        }

        return max;
    }
}

// ------------------------------------------------

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int rows = img1.length, cols = img1[0].length;
        List<Integer> la = new ArrayList<>(), lb = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (img1[r][c] == 1) la.add(r * 100 + c);
                if (img2[r][c] == 1) lb.add(r * 100 + c);
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int pa : la) {
            for (int pb : lb) {
                map.put(pa - pb, map.getOrDefault(pa - pb, 0) + 1); 
            }
        }

        int max = 0;
        for (int c : map.values()) {
            max = Math.max(max, c);
        }

        return max;
    }
}