class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        // Arrays.stream(strArray).collect(Collectors.toSet());
        int[] prefixSum = new int[words.length + 1];
        for (int i = 1; i < words.length + 1; i++) {
            String cur = words[i - 1];
            prefixSum[i] += prefixSum[i - 1] + (set.contains(cur.charAt(0)) && set.contains(cur.charAt(cur.length() - 1)) ? 1 : 0); 
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefixSum[queries[i][1] + 1] - prefixSum[queries[i][0]];
        }

        return res;
    }
}