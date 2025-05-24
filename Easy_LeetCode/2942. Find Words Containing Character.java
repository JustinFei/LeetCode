class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            // words[i].indexOf(x) != -1
            if (words[i].contains(String.valueOf(x))) {
                res.add(i);
            }
        }

        return res;
    }
}