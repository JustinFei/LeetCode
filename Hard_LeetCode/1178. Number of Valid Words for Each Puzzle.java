class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, List<Integer>> memo = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            memo.put(i, new ArrayList<>());
        }
        for (String word : words) {
            int temp = 0;
            for (char c : word.toCharArray()) {
                temp = temp | (1 << (c - 'a'));
            }
            for (int i = 0; i < 26; i++) {
                if ((temp & (1 << i)) != 0) {
                    memo.get(i).add(temp);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (String p : puzzles) {
            int temp = 0;
            for (char c : p.toCharArray()) {
                temp = temp | (1 << (c - 'a'));
            }
            int c = p.charAt(0) - 'a';
            int count = 0;
            for (int key : memo.get(c)) {
                if ((key & temp) == key) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }
}