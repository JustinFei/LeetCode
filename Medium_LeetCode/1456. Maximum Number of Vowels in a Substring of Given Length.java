class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        int count  = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            count += set.contains(s.charAt(i)) ? 1 : 0;
            if (i >= k) {
                count -= set.contains(s.charAt(i - k)) ? 1 : 0;
            }

            max = Math.max(count, max);
        }
        return max;
    }
}