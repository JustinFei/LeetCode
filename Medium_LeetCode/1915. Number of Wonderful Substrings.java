class Solution {
    public long wonderfulSubstrings(String word) {
        // Create the frequency map
        // Key = bitmask, Value = frequency of bitmask key
        Map<Integer, Integer> freq = new HashMap<>();

        // The empty prefix can be the smaller prefix, which is handled like this
        freq.put(0, 1);

        int mask = 0;
        long res = 0L;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';

            // Flip the parity of the c-th bit in the running prefix mask
            mask ^= (1 << c);
            
            // Count smaller prefixes that create substrings with no odd occurring letters
            res += freq.getOrDefault(mask, 0);

            // Increment value associated with mask by 1
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);

            // Loop through every possible letter that can appear an odd number of times in a substring
            for (int odd_c = 0; odd_c < 10; odd_c++) {
                res += freq.getOrDefault(mask ^ (1 << odd_c), 0);
            }
        }
        return res;
    }
}